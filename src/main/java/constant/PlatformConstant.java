package main.java.constant;

/**
 * 该类包含与应用程序中的平台相关的常量。
 */
public class PlatformConstant {

    // 防止类的实例化
    private PlatformConstant() {}

    /**
     * 平台的默认宽度。
     */
    public static final int WIDTH = 97;

    /**
     * 平台的默认高度。
     */
    public static final int HEIGHT = 16;

    /**
     * 平台的默认垂直速度（Y轴）。
     */
    public static final int DEFAULT_Y_SPEED = -10;

    /**
     * 平台的默认水平速度（X轴）。
     */
    public static final int DEFAULT_X_SPEED = 0;

    /**
     * 用于在平台超出此垂直位置时移除平台的基准线值。
     */
    public static final int REMOVE_BASE_LINE = -20;

    /**
     * 应用程序中平台的总数。
     */
    public static int PLATFORM_COUNT = 0;
}
