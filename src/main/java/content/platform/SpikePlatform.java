package main.java.content.platform;

import main.java.base.BaseEntity;
import main.java.constant.CommonUtils;
import main.java.constant.PlatformType;

import java.awt.*;

public class SpikePlatform extends BasePlatform {

    private static final Image spikePlatformImage = CommonUtils.getImage("spikePlatform.png");

    public SpikePlatform(int x, int y) {
        super(x,y);
        //Spike图片
        this.setHeight(32);
        setType(PlatformType.SPIKE);
        setFrontImage(getType().getImage());
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(), getY() + 10, getWidth(), getHeight());
    }
}
