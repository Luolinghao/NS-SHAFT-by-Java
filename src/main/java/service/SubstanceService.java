package main.java.service;

import main.java.base.BaseEntity;
import main.java.base.BaseEntityService;

public class SubstanceService extends BaseEntityService<BaseEntity> {
    /**
     * 物质服务单例
     */
    private static SubstanceService singletonInstance;

    /**
     * 私有构造函数，禁止外部创建实例
     */
    private SubstanceService(){}

    /**
     * 获取物质服务单例
     * @return 物质服务单例
     */
    public static synchronized SubstanceService getSingletonInstance() {
        if(singletonInstance == null) {
            singletonInstance = new SubstanceService();
        }
        return singletonInstance;
    }


}
