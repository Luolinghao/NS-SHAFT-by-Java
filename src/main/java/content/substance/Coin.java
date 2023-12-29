package main.java.content.substance;

import main.java.base.BaseEntity;
import main.java.constant.CommonUtils;
import main.java.content.player.Player;

import java.awt.*;

public class Coin extends Prop{
    public Coin(int x, int y) {
        super(x, y);
        this.setFrontImage(CommonUtils.getImage("coin.gif"));
    }

    public <T extends BaseEntity> void intersectsHandle(T other) {
        this.effect(other);
        this.setRemovable(true);
    }

    @Override
    public void drawImage(Graphics g) {
        g.drawImage(this.getImage(),this.getX(),this.getY(),this.getWidth(),this.getHeight(),null);
        //test
       // g.setColor(Color.ORANGE);
        //g.drawRect(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    }


    public void effect(BaseEntity entity) {

        if (entity instanceof Player) {
            ((Player) entity).getPlayerStatus().setScore(((Player) entity).getPlayerStatus().getScore()+2);
        }
    }
}


