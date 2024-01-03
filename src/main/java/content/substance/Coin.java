package main.java.content.substance;

import main.java.base.BaseEntity;
import main.java.constant.CommonUtils;
import main.java.content.player.Player;

import java.awt.*;

/**
 * 代表金币的类，继承自 {@link Prop}。
 */
public class Coin extends Prop {

    /**
     * 构造方法，初始化金币的位置，并设置金币的前景图像。
     *
     * @param x 金币的初始 x 坐标。
     * @param y 金币的初始 y 坐标。
     */
    public Coin(int x, int y) {
        super(x, y);
        this.setFrontImage(CommonUtils.getImage("coin.gif"));
    }

    /**
     * 处理与其他实体的交叉操作，触发金币的效果，并标记为可移除。
     *
     * @param other 与金币交叉的其他实体。
     * @param <T>   泛型参数，表示其他实体的类型。
     */
    public <T extends BaseEntity> void intersectsHandle(T other) {
        this.effect(other);
        this.setRemovable(true);
    }

    /**
     * 绘制金币的图像。
     *
     * @param g 用于绘制的图形上下文。
     */
    @Override
    public void drawImage(Graphics g) {
        g.drawImage(this.getImage(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
    }

    /**
     * 触发金币的效果，如果与玩家交叉，则增加玩家的分数。
     *
     * @param entity 与金币交叉的实体。
     */
    public void effect(BaseEntity entity) {
        if (entity instanceof Player) {
            ((Player) entity).getPlayerStatus().setScore(((Player) entity).getPlayerStatus().getScore() + 2);
        }
    }
}
