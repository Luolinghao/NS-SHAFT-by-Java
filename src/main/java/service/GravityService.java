package main.java.service;

import main.java.base.BaseService;
import main.java.base.IGravity;

/**
 * 重力服务
 * <p>实现游戏的重力功能,负责维护所有受重力影响的实体</p>
 */
public class GravityService extends BaseService<IGravity> {

    /**
     * 下落可以达到的最大速度
     */
    private static final int maxSpeed = 9;

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
     * 更新并维护列表
     * <p>重力服务不执行action</p>
     */
    public void update() {
       for(IGravity entity : this.getEntityList()) {
           //移除判断
            if(entity.isRemovable()) {
                this.remove(entity);
            }
           //重力判断
            if(!entity.isOnTheGround()) {
                if (entity.getYSpeed() >= maxSpeed) {
                    continue;
                }
                int dv =  entity.getQuality();
                entity.setYSpeed(entity.getYSpeed() + dv);
            }else {
                entity.setYSpeed(0);
            }
       }
    }


}
