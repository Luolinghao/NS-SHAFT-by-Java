package main.java.service;

import main.java.base.BaseEntityService;
import main.java.base.BaseGravityEntity;
import main.java.content.platform.BasePlatform;
import main.java.content.platform.SpikePlatform;

import java.awt.*;

/**
 * 平台服务类
 * <p>负责维护游戏中的所有平台实体</p>
 */
public class PlatformService extends BaseEntityService<BasePlatform> {

    /**
     * 平台服务单例
     */
    private static PlatformService singletonInstance;

    /**
     * 私有构造函数，禁止外部创建实例
     */
    private PlatformService(){}

    /**
     * 获取平台服务单例
     * @return 平台服务单例
     */
    public static synchronized PlatformService getSingletonInstance() {
        if(singletonInstance == null) {
            singletonInstance = new PlatformService();
        }
        return singletonInstance;
    }


    /**
     * 绘图
     * <p>遍历平台列表绘制平台</p>
     * @param g 需要绘制的画布的Graphics对象
     */
    @Override
    public void drawImage(Graphics g) {
        for (BasePlatform platform : this.getEntityList()) {
            platform.drawImage(g);
        }
    }


    /**
     * 地面判定
     * <p>遍历所有平台执行isAboveIntersectsWith判断</p>
     * <p>若处于一个平台上，则设置其onTheGround为true</p>
     * @param entity 待判定的实体
     */
    public void groundJudge(BaseGravityEntity entity) {
        for(BasePlatform platform : this.getEntityList()) {
            if(platform.isAboveIntersectsWith(entity)) {
                entity.setOnTheGround(true);
                entity.moveWithPlatform(platform);

                //修正人物坐标使其站在平台上
                if(platform instanceof SpikePlatform) {
                    entity.setY(platform.getY() + 8 - entity.getHeight());
                }else {
                    entity.setY(platform.getY() - 5 - entity.getHeight());
                }

                return;
            }
        }
        entity.setOnTheGround(false);
    }

}
