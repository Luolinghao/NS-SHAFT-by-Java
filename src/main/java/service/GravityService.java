package main.java.service;

import main.java.base.BaseEntity;
import main.java.base.BaseService;
import main.java.base.IGravity;

/**
 * 重力服务
 * <p>实现游戏的重力功能</p>
 */
public class GravityService extends BaseService<IGravity> {
    /**
     * 重力加速度
     */
    private static final int g = 10;

    /**
     * 重力服务单例
     */
    private static GravityService singletonInstance;

    /**
     * 私有构造函数，禁止外部创建实例
     */
    private GravityService(){}

    /**
     * 获取重力服务单例
     * @return 重力服务单例
     */
    public static synchronized GravityService getSingletonInstance() {
        if(singletonInstance == null) {
            singletonInstance = new GravityService();
        }
        return singletonInstance;
    }

    /**
     * 维护列表
     * 重力服务不执行action
     */
    public void update() {
       for(IGravity entity : this.getEntityList()) {
           //移除判断
            if(entity.isRemovable()) {
                this.remove(entity);
            }
           //重力判断
            if(!entity.isOnTheGround()) {
                int dy = g * entity.getQuality();
                entity.setY(entity.getY() + dy);
            }
       }
    }


}
