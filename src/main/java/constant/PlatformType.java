package main.java.constant;


import java.awt.*;

public enum PlatformType {
    NORMAL("normalPlatform.png"),
    FAKE("fakePlatform.png"),
    SPIKE("spikePlatform.png");

    private final Image image;

    PlatformType(String imageName){
        this.image = CommonUtils.getImage(imageName);
    }


    public Image getImage(){
        return image;
    }

    public boolean isNormal() {
        return this.equals(NORMAL);
    }
    public boolean isFake() {
        return this.equals(FAKE);
    }
    public boolean isSpike() {
        return this.equals(SPIKE);
    }

}
