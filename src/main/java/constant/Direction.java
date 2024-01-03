package main.java.constant;

public enum Direction {
    LEFT,
    RIGHT,
    FRONT;

    public boolean isRight() {
        return this.equals(RIGHT);
    }

}
