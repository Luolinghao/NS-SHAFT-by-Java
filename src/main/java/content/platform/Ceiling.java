package main.java.content.platform;

import main.java.base.BaseEntity;
import main.java.constant.CommonUtils;
import main.java.content.player.Player;

import java.awt.*;

public class Ceiling extends BasePlatform {

    public Ceiling() {
        super(24, 0);
        this.setHeight(24);
        this.setWidth(24*25);
        this.setFrontImage(CommonUtils.getImage("ceiling.png"));
    }

    @Override
    public <T extends BaseEntity> void intersectsHandle(T other) {
        if(other instanceof Player) {
            ((Player) other).beHurt(1);
        }
    }

    @Override
    public void action() {

    }
}
