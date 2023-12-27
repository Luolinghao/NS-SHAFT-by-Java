package main.java.content.substance;

import main.java.base.BaseEntity;
import main.java.content.player.Player;

public class shield extends Prop{
    public shield(int x, int y) {
        super(x, y);
    }
    @Override
    public <T extends BaseEntity> void intersectsHandle(T other) {
        if(other instanceof Player) {
            this.effect(other);
            this.setRemovable(true);
        }
    }


    public void effect(Player p) {
        p.getPlayerStatus().setHaveShield(true);
    }
}
