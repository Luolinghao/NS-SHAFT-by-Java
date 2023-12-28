package main.java.service;

/**
 * 服务类
 * <p>将服务类单例整合在外部统一通过本类进行调用</p>
 */
public abstract class Service {
    /**
     * 平台服务的单例对象
     */
    public static final PlatformService platform = PlatformService.getSingletonInstance();

    /**
     * 重力服务的单例对象
     */
    public static final GravityService gravity = GravityService.getSingletonInstance();

    /**
     * 物质(道具...)服务的单例对象
     */
    public static final SubstanceService substance = SubstanceService.getSingletonInstance();

    /**
     * 初始化函数，进行类的加载，构造服务对象的单例
     */
    public static void init(){}
}

