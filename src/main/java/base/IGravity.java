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

    boolean isRemovable();

    int getY();

    void setY(int y);


}
