package main.java.content.substance;

import main.java.base.BaseEntity;
import main.java.content.player.Player;

public class Coin extends Prop{
    public Coin(int x, int y) {
        super(x, y);
    }
    public <T extends BaseEntity> void intersectsHandle(T other) {
        this.effect(other);
        this.setRemovable(true);
    }


    public void effect(BaseEntity entity) {

        if (entity instanceof Player) {
            ((Player) entity).getPlayerStatus().setScore(((Player) entity).getPlayerStatus().getScore()+2);
        }
    }
}


