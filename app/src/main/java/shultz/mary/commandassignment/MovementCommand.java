package shultz.mary.commandassignment;

import android.app.Activity;

/**
 * Created by Mary on 4/25/2017.
 */

public class MovementCommand extends Command {
    private MovementType actionMovement;

    public MovementCommand(MainActivity currentActivity, MovementType actionMovement){
        super(currentActivity);
        this.setActionMovement(actionMovement);
    }
    @Override
    public void execute() {
        currentActivity.moveSquare(actionMovement.getIncrementValue());
    }

    @Override
    public void undo() {
        currentActivity.moveSquare(actionMovement.getOppositeVal());
    }

    private void setActionMovement(MovementType actionMovement){
        this.actionMovement = actionMovement;
    }
}
