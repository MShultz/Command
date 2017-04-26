package shultz.mary.commandassignment;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    protected static final int UD_INCREMENT_VALUE = 5;
    protected static final int LR_INCREMENT_VALUE = 1;
    protected final int ROW = 0;
    protected final int COL = 1;
    private Stack<Command> applicationHistory;
    private int currentLocation;
    private int currentColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        applicationHistory = new Stack<>();

        this.setCurrentLocation(R.id.r3c3);
        this.setCurrentColor(Color.BLACK);

    }

    public void onMovement(View view) {
        String tag = view.getTag().toString();
        if (isValidMove(tag)) {
            MovementCommand newMovement;
            switch (tag) {
                case "up":
                    newMovement = new MovementCommand(this, MovementType.UP);
                    break;
                case "down":
                    newMovement = new MovementCommand(this, MovementType.DOWN);
                    break;
                case "left":
                    newMovement = new MovementCommand(this, MovementType.LEFT);
                    break;
                case "right":
                    newMovement = new MovementCommand(this, MovementType.RIGHT);
                    break;
                default:
                    throw new IllegalStateException();
            }
            newMovement.execute();
            applicationHistory.push(newMovement);
        } else {
            Toast.makeText(this, "Not a valid move.", Toast.LENGTH_SHORT).show();
        }
    }

    public void onUndo(View view) {
        if (!applicationHistory.isEmpty())
            applicationHistory.pop().undo();
        else
            Toast.makeText(this, "Undo History Empty", Toast.LENGTH_SHORT).show();
    }

    public void onColorChange(View view) {
        String tag = view.getTag().toString();
        if (isValidColor(tag)) {
            ColorCommand newColor;
            switch (tag) {
                case "red":
                    newColor = new ColorCommand(this, currentColor, Color.RED);
                    break;
                case "green":
                    newColor = new ColorCommand(this, currentColor, Color.GREEN);
                    break;
                case "blue":
                    newColor = new ColorCommand(this, currentColor, Color.BLUE);
                    break;
                default:
                    throw new IllegalStateException();
            }
            newColor.execute();
            applicationHistory.push(newColor);
        } else {
            Toast.makeText(this, "Already the current Color.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setCurrentLocation(int newLocation) {
        this.currentLocation = newLocation;
    }

    private void setCurrentColor(int newColor) {
        this.currentColor = newColor;
    }

    public void moveSquare(int direction) {
        findViewById(currentLocation).setBackgroundColor(ContextCompat.getColor(this, R.color.defaultBackground));
        currentLocation += direction;
        findViewById(currentLocation).setBackgroundColor(currentColor);
    }

    public void setColor(int color) {
        this.setCurrentColor(color);
        findViewById(currentLocation).setBackgroundColor(currentColor);

    }

    private boolean isValidMove(String tag) {
        boolean isValid = true;
        String[] current = findViewById(currentLocation).getTag().toString().split(",");
        switch (tag) {
            case "up":
                if (current[ROW].equals("1"))
                    isValid = false;
                break;
            case "down":
                if (current[ROW].equals("5"))
                    isValid = false;
                break;
            case "left":
                if (current[COL].equals("1"))
                    isValid = false;
                break;
            case "right":
                if (current[COL].equals("5"))
                    isValid = false;
        }
        return isValid;
    }

    private boolean isValidColor(String tag) {
        boolean isValid = true;

        switch (tag) {
            case "red":
                if (currentColor == Color.RED)
                    isValid = false;
                break;
            case "green":
                if (currentColor == Color.GREEN)
                    isValid = false;
                break;
            case "blue":
                if (currentColor == Color.BLUE)
                    isValid = false;
                break;
        }
        return isValid;
    }
}