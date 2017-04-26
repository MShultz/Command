package shultz.mary.commandassignment;

/**
 * Created by Mary on 4/25/2017.
 */

public enum MovementType {
    UP(-MainActivity.UD_INCREMENT_VALUE),
    DOWN(MainActivity.UD_INCREMENT_VALUE),
    LEFT(-MainActivity.LR_INCREMENT_VALUE),
    RIGHT(MainActivity.LR_INCREMENT_VALUE);


    private int value;

    MovementType(int value) {
        this.setValue(value);
    }

    private void setValue(int value) {
        this.value = value;
    }

    public int getIncrementValue(){
        return value;
    }

    public int getOppositeVal(){
       return (-1)*value;
    }

}
