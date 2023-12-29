package main.java.content.platform;

import main.java.base.BaseEntity;
import main.java.constant.CommonUtils;
import main.java.content.player.Player;

import java.awt.*;

public class Ceiling extends BasePlatform {

    private int hurtPeriod = 25;

    private int timeSinceLastHurt = 0;

    private boolean isIntersectsWithPlayer = false;

    private boolean isFirstIntersectWithPlayer = true;

    private int hurtValue = 1;


    public Ceiling() {
        super(24, 0);
        this.setHeight(24);
        this.setWidth(540);
        this.setFrontImage(CommonUtils.getImage("ceiling.png"));
    }


    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public <T extends BaseEntity> void intersectsHandle(T other) {
        if(other instanceof Player) {
            //如果是第一次受到伤害
            if(this.isFirstIntersectWithPlayer) {
                //执行玩家受伤判定
                ((Player) other).beHurt(hurtValue);
                this.isFirstIntersectWithPlayer = false;
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

    @Override
    public <T extends BaseEntity> boolean isAboveIntersectsWith(T otherEntity) {
        return false;
    }

    @Override
    public void action() {

    }
}
