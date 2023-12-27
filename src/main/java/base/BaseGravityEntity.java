package main.java.base;

import main.java.content.platform.BasePlatform;

/**
 * 基础重力实体类
 * <p> 是游戏中受到重力功能控制的实体对象的基类
 */
public abstract class BaseGravityEntity extends BaseEntity implements IGravity {

    /**
     * 用于判断实体是否处于地面的布尔量
     */
    private boolean onTheGround;


    public BaseGravityEntity(int x,int y) {
        super(x,y);
    }

    /**
     * 判断实体是否处于地面
     * @return 在地面返回ture,否则返回false
     */
    @Override
    public boolean isOnTheGround() {
        return this.onTheGround;
    }

    /**
     * 设置实体是否处于地面的状态
     * @param onTheGround 实体是否处于地面的布尔量
     */
    public void setOnTheGround(boolean onTheGround) {
        this.onTheGround = onTheGround;
    }

    /**
     * 获取实体质量（默认为1）
     * <p>若需不同下落速度，可覆写方法返回不同质量</p>
     * @return 实体质量
     */
    @Override
    public int getQuality() {
        return 1;
    }
}
