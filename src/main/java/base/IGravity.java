package main.java.base;

/**
 * 重力接口
 * <p>受重力影响的对象需对外提供的接口</p>
 */
public interface IGravity {

    /**
     * 判断实现接口的对象是否处于地面
     * @return 在地面上返回ture 否则返回false
     */
    boolean isOnTheGround();

    /**
     * 获取对象质量
     */
    int getQuality();

    /**
     * 判断该对象是否不受重力影响
     * @return 如果不受重力影响返回true,否则返回false
     */
    boolean isRemovable();

    /**
     * 获取本对象的左上顶点y轴坐标
     * @return 左上顶点y坐标
     */
    int getY();

    /**
     * 设置y轴坐标
     * @param y 左上顶点y坐标
     */
    void setY(int y);

    int getYSpeed();

    void setYSpeed(int ySpeed);
}
