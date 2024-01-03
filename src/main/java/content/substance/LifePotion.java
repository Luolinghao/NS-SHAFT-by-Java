package main.java.content.substance;

import main.java.base.BaseEntity;
import main.java.constant.CommonUtils;
import main.java.content.player.Player;

import java.awt.*;

/**
 * 代表生命药水的类，继承自 {@link Prop}。
 */
public class LifePotion extends Prop {

    /**
     * 构造方法，初始化生命药水的位置，并设置生命药水的前景图像。
     *
     * @param x 生命药水的初始 x 坐标。
     * @param y 生命药水的初始 y 坐标。
     */
    public LifePotion(int x, int y) {
        super(x, y);
        this.setFrontImage(CommonUtils.getImage("lifePotion.gif"));
    }

    /**
     * 处理与其他实体的交叉操作，触发生命药水的效果，并标记为可移除。
     *
     * @param other 与生命药水交叉的其他实体。
     * @param <T>   泛型参数，表示其他实体的类型。
     */
    @Override
    public <T extends BaseEntity> void intersectsHandle(T other) {
        this.effect(other);
        this.setRemovable(true);
    }

    /**
     * 触发生命药水的效果，如果与玩家交叉，则根据玩家当前生命值进行相应操作。
     *
     * @param entity 与生命药水交叉的实体。
     */
    @Override
    public void effect(BaseEntity entity) {
        // 如果是玩家
        if (entity instanceof Player) {
            // 如果玩家生命值大于等于8且处于正常状态
            if (((Player) entity).getPlayerStatus().getHp().getValue() >= 8 && ((Player) entity).getPlayerStatus().getHp().isNormal()) {
                ((Player) entity).getPlayerStatus().getHp().setValue(10); // 生命值设为最大值
            } else if (((Player) entity).getPlayerStatus().getHp().isNormal() && ((Player) entity).getPlayerStatus().getHp().getValue() < 8) {
                ((Player) entity).getPlayerStatus().getHp().addLessMax(2); // 生命值增加2点
            }
        }
    }

    /**
     * 绘制生命药水的图像。
     *
     * @param g 用于绘制的图形上下文。
     */
    @Override
    public void drawImage(Graphics g) {
        g.drawImage(this.getImage(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
    }
}
