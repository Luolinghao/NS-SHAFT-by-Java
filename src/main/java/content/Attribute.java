package main.java.content;

import org.omg.CORBA.PUBLIC_MEMBER;

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

    public void setValue(int value) {
        this.value = value;
    }

    public void subtract(int subtractValue){
        this.value -= subtractValue;
    }

    public void addLessMax(int addValue) {

        if(addValue + this.value <= maxValue){
            this.value += addValue;
        } else {
            this.value = maxValue;
        }

    }

}
