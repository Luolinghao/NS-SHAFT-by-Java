package main.java.content;

/**
 * 属性封装类
 */
public class Attribute {
    private int value;
    private int minValue;

    private int maxValue;

    public Attribute(int value, int minValue, int maxValue) {
        this.value = value;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    public boolean isNormal() {
        return value >= minValue && value <= maxValue;
    }

    public int getValue() {
        return value;
    }

    public void subtract(int subtractValue){
        this.value -= subtractValue;
    }

}
