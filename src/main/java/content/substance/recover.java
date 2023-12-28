package main.java.content.substance;

import main.java.base.BaseEntity;
import main.java.content.player.Player;

import java.awt.*;

public class recover extends Prop{

    private final int recoverValue = 2;

    public recover(int x, int y) {
            super(x, y);
        }
    @Override
    public <T extends BaseEntity> void intersectsHandle(T other) {
        this.effect(other);
        this.setRemovable(true);
    }

    @Override
    public void effect(BaseEntity entity) {
        //如果是玩家
        if(entity instanceof Player) {
            Player player = (Player) entity;
            player.getPlayerStatus().getHp().addLessMax(recoverValue);
        }
    }
    @Override
    public void drawImage(Graphics g) {
        g.drawImage(this.getImage(),this.getX(),this.getY(),this.getWidth(),this.getHeight(),null);
        //test
        g.setColor(Color.RED);
        g.drawRect(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    }
}
