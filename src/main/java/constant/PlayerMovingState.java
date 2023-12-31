package main.java.constant;

import java.awt.*;

/**
 * 玩家运动状态枚举类
 * <p>存储玩家运动状态名及对应图片</p>
 */
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
