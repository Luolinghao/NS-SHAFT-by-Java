package main.java.content.substance;

import main.java.base.BaseEntity;
import main.java.content.player.Player;

/**
 * 代表道具的抽象类，继承自 {@link BaseEntity}。
 */
public abstract class Prop extends BaseEntity {

    /**
     * 道具类的构造方法，初始化道具的位置。
     *
     * @param x 道具的初始 x 坐标。
     * @param y 道具的初始 y 坐标。
     */
    Prop(int x, int y) {
        super(x, y);
    }

    /**
     * 处理与其他实体的交叉操作，默认实现为与玩家交叉时触发道具效果并标记为可移除。
     *
     * @param other 与道具交叉的其他实体。
     * @param <T>   泛型参数，表示其他实体的类型。
     */
    @Override
    public <T extends BaseEntity> void intersectsHandle(T other) {
        if (other instanceof Player) {
            this.effect(other);
            this.setRemovable(true);
        }
    }

    /**
     * 触发道具的效果，具体实现由子类负责。
     *
     * @param entity 与道具交叉的实体。
     */
    public abstract void effect(BaseEntity entity);
}
