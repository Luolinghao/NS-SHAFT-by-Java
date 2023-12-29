package main.java.constant;

/**
 * 系统配置常量
 */
public class ConfigConstant {
    /**
     * 私有构造函数，不允许外部创建实例
     */
    private ConfigConstant(){}

    /**
     * Timer管理开关，用于管理所有计时器线程
     */
    public static boolean TIMER_ALL_STOP = false;

    /**
     * 游戏难度
     */
    public static int GAME_LEVEL = 0;

    public static boolean GAME_START;
    public static boolean GAME_MODE_TWO_PLAYER = false;

    public static boolean START_PANEL_IS_FIRST_START = true;

    public static final String IMAGE_RESOURCES_PATH = "src/main/resources/image/";

    public static boolean START = false;



}
