package main.java.content.substance;

import main.java.base.BaseEntity;
import main.java.content.player.Player;

public class shield extends Prop{
    public shield(int x, int y) {
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

}
