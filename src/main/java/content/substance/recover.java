package main.java.content.substance;

import main.java.base.BaseEntity;
import main.java.content.player.Player;

import java.awt.*;

public class recover extends Prop{
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
            if(((Player) entity).getPlayerStatus().getHp().getValue()>=8&&((Player) entity).getPlayerStatus().getHp().isNormal()){
                ((Player) entity).getPlayerStatus().getHp().setValue(10);
            }
            else if (((Player) entity).getPlayerStatus().getHp().isNormal()&&((Player) entity).getPlayerStatus().getHp().getValue()<8){
                ((Player) entity).getPlayerStatus().getHp().addtract(2);
            }
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
