package main.java.content.platform;

import main.java.base.BaseEntity;
import main.java.constant.PlatformType;
import main.java.content.player.Player;

import java.awt.*;

public class SpikePlatform extends BasePlatform {

    private int hurtPeriod = 10;

    private int timeSinceLastHurt = 0;

    private boolean isIntersectsWithPlayer = false;

    private boolean isFirstIntersectWithPlayer = true;

    private int hurtValue = 1;



    public SpikePlatform(int x, int y) {
        super(x,y);
        //Spike图片高度与其余平台不同，单独设置高度
        this.setHeight(32);
        setType(PlatformType.SPIKE);
        setFrontImage(getType().getImage());
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(), getY() + 10, getWidth(), getHeight());
    }

    @Override
    public <T extends BaseEntity> void intersectsHandle(T other) {
        if(other instanceof Player) {
            //如果是第一次受到伤害
            if(this.isFirstIntersectWithPlayer) {
                //执行玩家受伤判定
                ((Player) other).beHurt(hurtValue);
                return;
            }
            //距离上次伤害的时间增加(即伤害逻辑判断距离上次的执行次数)
            this.timeSinceLastHurt++;
            //当距离上次的时间达到伤害周期
            if(this.timeSinceLastHurt == this.hurtPeriod) {
                //执行伤害判定
                ((Player) other).beHurt(hurtValue);
                this.timeSinceLastHurt = 0;
            }
        }

    }


}
