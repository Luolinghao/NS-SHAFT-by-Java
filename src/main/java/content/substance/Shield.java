package main.java.content.substance;

import main.java.base.BaseEntity;
import main.java.content.player.Player;

import java.awt.*;

public class Shield extends Prop{
    public Shield(int x, int y) {
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
            ((Player) entity).getPlayerStatus().setHaveShield(true);
        }
    }
    @Override
    public void drawImage(Graphics g) {
        g.drawImage(this.getImage(),this.getX(),this.getY(),this.getWidth(),this.getHeight(),null);
        //test
        g.setColor(Color.BLUE);
        g.drawRect(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    }
}
