package main.java.content.substance;

import main.java.base.BaseEntity;
import main.java.constant.CommonUtils;
import main.java.content.player.Player;

import java.awt.*;

/**
 * 代表护盾道具的类，继承自 {@link Prop}。
 */
public class Shield extends Prop {

    /**
     * 构造方法，初始化护盾道具的位置，并设置护盾道具的前景图像。
     *
     * @param x 护盾道具的初始 x 坐标。
     * @param y 护盾道具的初始 y 坐标。
     */
    public Shield(int x, int y) {
        super(x, y);
        this.setFrontImage(CommonUtils.getImage("shield.gif"));
    }

    /**
     * 处理与其他实体的交叉操作，触发护盾道具的效果，并标记为可移除。
     *
     * @param other 与护盾道具交叉的其他实体。
     * @param <T>   泛型参数，表示其他实体的类型。
     */
    @Override
    public <T extends BaseEntity> void intersectsHandle(T other) {
        this.effect(other);
        this.setRemovable(true);
    }

    /**
     * 触发护盾道具的效果，如果与玩家交叉，则使玩家拥有护盾。
     *
     * @param entity 与护盾道具交叉的实体。
     */
    @Override
    public void effect(BaseEntity entity) {
        // 如果是玩家
        if (entity instanceof Player) {
            ((Player) entity).getPlayerStatus().setHaveShield(true); // 玩家拥有护盾
        }
    }

    /**
     * 绘制护盾道具的图像。
     *
     * @param g 用于绘制的图形上下文。
     */
    @Override
    public void drawImage(Graphics g) {
        g.drawImage(this.getImage(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
    }
}
