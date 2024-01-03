package main.java.constant;

import java.awt.*;

/**
 * 平台类型的枚举，包含普通、虚假和刺刀平台。
 */
public enum PlatformType {
    /**
     * 普通平台，使用 "normalPlatform.png" 图像。
     */
    NORMAL("normalPlatform.png"),

    /**
     * 虚假平台，使用 "fakePlatform.png" 图像。
     */
    FAKE("fakePlatform.png"),

    /**
     * 刺刀平台，使用 "spikePlatform.png" 图像。
     */
    SPIKE("spikePlatform.png");

    private final Image image;

    /**
     * 构造函数，根据给定的图像名称初始化平台类型。
     *
     * @param imageName 图像文件的名称。
     */
    PlatformType(String imageName) {
        this.image = CommonUtils.getImage(imageName);
    }

    /**
     * 获取平台类型对应的图像。
     *
     * @return 平台类型的图像。
     */
    public Image getImage() {
        return image;
    }

    /**
     * 检查是否为普通平台。
     *
     * @return 如果是普通平台，则返回 true；否则返回 false。
     */
    public boolean isNormal() {
        return this.equals(NORMAL);
    }

    /**
     * 检查是否为虚假平台。
     *
     * @return 如果是虚假平台，则返回 true；否则返回 false。
     */
    public boolean isFake() {
        return this.equals(FAKE);
    }

    /**
     * 检查是否为刺刀平台。
     *
     * @return 如果是刺刀平台，则返回 true；否则返回 false。
     */
    public boolean isSpike() {
        return this.equals(SPIKE);
    }
}
