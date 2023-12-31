package main.java.constant;

import java.awt.*;

public enum PropType {
    COIN("coin.gif"),
    LIFE_POTION("lifePotion.gif"),
    SHIELD("shield.gif");


    private final Image image;

    PropType(String imageName) {
        this.image = CommonUtils.getImage(imageName);
    }

    public Image getImage() {
        return image;
    }

}
