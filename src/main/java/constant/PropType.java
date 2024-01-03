package main.java.constant;

import java.awt.*;

/**
 * 道具类型的枚举，包含硬币、生命药水和盾牌。
 */
public enum PropType {

    /**
     * 硬币道具，使用 "coin.gif" 图像。
     */
    COIN("coin.gif"),

    /**
     * 生命药水道具，使用 "lifePotion.gif" 图像。
     */
    LIFE_POTION("lifePotion.gif"),

    /**
     * 盾牌道具，使用 "shield.gif" 图像。
     */
    SHIELD("shield.gif");

    private final Image image;

    /**
     * 构造函数，根据给定的图像名称初始化道具类型。
     *
     * @param imageName 图像文件的名称。
     */
    PropType(String imageName) {
        this.image = CommonUtils.getImage(imageName);
    }

    /**
     * 获取道具类型对应的图像。
     *
     * @return 道具类型的图像。
     */
    public Image getImage() {
        return image;
    }

}
