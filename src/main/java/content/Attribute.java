package main.java.content;

/**
 * 表示属性的封装类。
 */
public class Attribute {

    private int value;      // 属性值
    private int minValue;   // 最小属性值
    private int maxValue;   // 最大属性值

    /**
     * 构造方法，初始化属性的值、最小值和最大值。
     *
     * @param value    属性的初始值。
     * @param minValue 属性的最小值。
     * @param maxValue 属性的最大值。
     */
    public Attribute(int value, int minValue, int maxValue) {
        this.value = value;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    /**
     * 判断属性是否处于正常范围内。
     *
     * @return 如果属性值在最小值和最大值之间，则返回 true；否则返回 false。
     */
    public boolean isNormal() {
        return value >= minValue && value <= maxValue;
    }

    /**
     * 获取属性的值。
     *
     * @return 属性的值。
     */
    public int getValue() {
        return value;
    }

    /**
     * 设置属性的值。
     *
     * @param value 要设置的属性值。
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 减去指定值，更新属性值。
     *
     * @param subtractValue 要减去的值。
     */
    public void subtract(int subtractValue) {
        this.value -= subtractValue;
    }

    /**
     * 增加指定值，但不超过最大值，更新属性值。
     *
     * @param addValue 要增加的值。
     */
    public void addLessMax(int addValue) {
        if (addValue + this.value <= maxValue) {
            this.value += addValue;
        } else {
            this.value = maxValue;
        }
    }
}
