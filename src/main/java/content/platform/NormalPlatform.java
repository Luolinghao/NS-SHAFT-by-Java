package main.java.content.platform;

import main.java.constant.PlatformType;


public class NormalPlatform extends BasePlatform {

    public NormalPlatform(int x, int y) {
        super(x,y);
        setType(PlatformType.NORMAL);
        setFrontImage(getType().getImage());
    }
}
