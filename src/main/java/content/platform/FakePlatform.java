package main.java.content.platform;

import main.java.base.BaseEntity;
import main.java.constant.PlatformType;
import main.java.content.player.Player;

import java.awt.*;

/**
 * 虚假平台类，继承自基础平台类 {@link BasePlatform}。
 */
public class FakePlatform extends BasePlatform {

    private int removeTime;

    private boolean isIntersectsWithPlayer;

    /**
     * 虚假平台的构造函数，初始化平台的位置、类型和前景图像。
     *
     * @param x 平台的 x 坐标。
     * @param y 平台的 y 坐标。
     */
    public FakePlatform(int x, int y) {
        super(x, y);
        this.removeTime = 0;
        isIntersectsWithPlayer = false;
        this.setType(PlatformType.FAKE);
        this.setFrontImage(getType().getImage());
    }

    /**
     * 检查平台上方是否与其他实体交叉，并在与玩家交叉时增加移除时间。
     *
     * @param otherEntity 待检查的其他实体。
     * @return 如果平台上方与其他实体交叉，则返回 true；否则返回 false。
     */
    @Override
    public <T extends BaseEntity> boolean isAboveIntersectsWith(T otherEntity) {
        if (otherEntity instanceof Player) {
            this.isIntersectsWithPlayer = super.isAboveIntersectsWith(otherEntity);
            if (isIntersectsWithPlayer) {
                removeTime++;
            }
        }
        if (removeTime == 8) {
            this.setRemovable(true);
        }
        return super.isAboveIntersectsWith(otherEntity);
    }

    /**
     * 执行虚假平台的动作。
     */
    @Override
    public void action() {
        // 实现虚假平台的特定动作逻辑，如果有的话
        super.action();
    }
}
