package main.java.constant;

public enum Direction {
    LEFT,
    RIGHT,
    FRONT;

    public boolean isLeft() {
        return this.equals(LEFT);
    }

    public boolean isRight() {
        return this.equals(RIGHT);
    }

    public boolean isFront() {
        return this.equals(FRONT);
    }
}
