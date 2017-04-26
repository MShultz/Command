package shultz.mary.commandassignment;

import android.app.Activity;

/**
 * Created by Mary on 4/24/2017.
 */

public abstract class Command {
    protected MainActivity currentActivity;
    public Command(MainActivity currentActivity){
        this.setCurrentActivity(currentActivity);
    }
    private void setCurrentActivity(MainActivity currentActivity){
        this.currentActivity = currentActivity;
    }
    public abstract void execute();
    public abstract void undo();

}
