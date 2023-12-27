package main.java.content.platform;

import main.java.base.BaseEntity;
import main.java.constant.PlatformType;
import main.java.content.player.Player;

import java.awt.*;

public class FakePlatform extends BasePlatform {

    private int removeTime;

    private boolean isIntersectsWithPlayer;

    public FakePlatform(int x,int y){
        super(x,y);
        this.removeTime = 0;
        isIntersectsWithPlayer = false;
        this.setType(PlatformType.FAKE);
        this.setFrontImage(getType().getImage());
    }

    @Override
    public <T extends BaseEntity> boolean isAboveIntersectsWith(T otherEntity) {
        if(otherEntity instanceof Player) {
            this.isIntersectsWithPlayer = super.isAboveIntersectsWith(otherEntity);
        }
        return super.isAboveIntersectsWith(otherEntity);
    }

    @Override
    public void action() {
        if(isIntersectsWithPlayer){
            removeTime++;
        }
        if(removeTime == 8){
            this.setRemovable(true);
        }
        super.action();
    }


}
