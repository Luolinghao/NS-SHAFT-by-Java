package main.java.content.platform;

import main.java.constant.PlatformType;

/**
 * 普通平台类，继承自基础平台类 {@link BasePlatform}。
 */
public class NormalPlatform extends BasePlatform {

    /**
     * 普通平台的构造函数，初始化平台的位置、类型和前景图像。
     *
     * @param x 平台的 x 坐标。
     * @param y 平台的 y 坐标。
     */
    public NormalPlatform(int x, int y) {
        super(x, y);
        setType(PlatformType.NORMAL);
        setFrontImage(getType().getImage());
    }
}
