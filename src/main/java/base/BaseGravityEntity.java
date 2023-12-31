package main.java.base;


/**
 * 基础重力实体类
 * <p> 是游戏中受到重力功能控制的实体对象的基类
 */
public abstract class BaseGravityEntity extends BaseEntity implements IGravity {

    /**
     * 用于判断实体是否处于地面的布尔量
     */
    private boolean onTheGround;

    /**
     * BaseGravityEntity类的构造函数
     * <p>调用BaseEntity的构造函数进行初始化</p>
     * @param x 左上顶点x坐标
     * @param y 左上顶点y坐标
     */
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
