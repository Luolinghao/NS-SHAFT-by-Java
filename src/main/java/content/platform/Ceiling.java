package main.java.content.platform;

import main.java.base.BaseEntity;
import main.java.constant.CommonUtils;
import main.java.content.player.Player;

import java.awt.*;

/**
 * 天花板平台类，继承自基础平台类 {@link BasePlatform}。
 */
public class Ceiling extends BasePlatform {

    private int hurtPeriod = 25;

    private int timeSinceLastHurt = 0;

    private boolean isIntersectsWithPlayer = false;

    private boolean isFirstIntersectWithPlayer = true;

    private int hurtValue = 1;

    /**
     * 天花板平台的构造函数。
     * 初始化平台的位置、高度、宽度和前景图像。
     */
    public Ceiling() {
        super(24, 0);
        this.setHeight(24);
        this.setWidth(540);
        this.setFrontImage(CommonUtils.getImage("ceiling.png"));
    }

    /**
     * 获取天花板平台的矩形边界。
     *
     * @return 天花板平台的矩形边界。
     */
    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    /**
     * 处理与其他实体的交叉。
     *
     * @param other 与之交叉的其他实体。
     */
    @Override
    public <T extends BaseEntity> void intersectsHandle(T other) {
        if (other instanceof Player) {
            // 如果是第一次受到伤害
            if (this.isFirstIntersectWithPlayer) {
                // 执行玩家受伤判定
                ((Player) other).beHurt(hurtValue);
                this.isFirstIntersectWithPlayer = false;
                return;
            }
            // 距离上次伤害的时间增加（即伤害逻辑判断距离上次的执行次数）
            this.timeSinceLastHurt++;
            // 当距离上次的时间达到伤害周期
            if (this.timeSinceLastHurt == this.hurtPeriod) {
                // 执行伤害判定
                ((Player) other).beHurt(hurtValue);
                this.timeSinceLastHurt = 0;
            }
        }
    }

    /**
     * 检查平台上方是否与其他实体交叉。
     *
     * @param otherEntity 待检查的其他实体。
     * @return 如果平台上方与其他实体交叉，则返回 true；否则返回 false。
     */
    @Override
    public <T extends BaseEntity> boolean isAboveIntersectsWith(T otherEntity) {
        return false;
    }

    /**
     * 执行平台的动作。
     */
    @Override
    public void action() {
        // 实现平台的特定动作逻辑，如果有的话
    }
}
