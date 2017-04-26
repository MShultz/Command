package shultz.mary.commandassignment;

/**
 * Created by Mary on 4/25/2017.
 */

public class ColorCommand extends Command {
    private int previousColor;
    private int currentColor;

    public ColorCommand(MainActivity currentActivity, int previousColor, int currentColor) {
        super(currentActivity);
        this.setPreviousColor(previousColor);
        this.setCurrentColor(currentColor);
    }

    @Override
    public void execute() {
        currentActivity.setColor(currentColor);
    }

    @Override
    public void undo() {
        currentActivity.setColor(previousColor);
    }


    public void setPreviousColor(int previousColor) {
        this.previousColor = previousColor;
    }

    public void setCurrentColor(int currentColor) {
        this.currentColor = currentColor;
    }
}
