package main.java.constant;

import java.awt.*;

public enum PlayerMovingState {
    LEFT_RUN("playerLeft.gif"),
    RIGHT_RUN("playerRight.gif"),
    STOP("playerFront.png");


    private final Image image;

    PlayerMovingState(String imageName) {
        image = CommonUtils.getImage(imageName);
    }


    public Image getImage() {
        return image;
    }
}
