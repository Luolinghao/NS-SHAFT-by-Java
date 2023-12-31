package main.java.base;

import main.java.content.player.Player;


import java.awt.*;

/**
 * 对实体对象提供的服务
 * <p>每种实体对象服务的服务列表应该没有交集</p>
 * <p>实体对象服务还要执行维护对象的action</p>
 * @param <T>BaseEntity类及其子类
 */
public abstract class BaseEntityService<T extends BaseEntity> extends BaseService<T>{

    /**
     * <p>1.执行服务</p>
     * <p>2.更新服务列表</p>
     * <p>3.执行每个实体对象的action</p>
     */
    public void update(Player... players) {

        for(Player player : players) {
            for(T entity : this.getEntityList()) {
                //移除判断逻辑
                if(isRemovable(entity)) {
                    this.remove(entity);
                    continue;
                }

                //与玩家相交处理
                if(entity.isIntersectsWith(player)) {
                    entity.intersectsHandle(player);
                }
            }
        }

        for(T entity : this.getEntityList()) {
            entity.action();
        }
    }



    /**
     * 判断传入的实体是否可以从服务列表中移除
     * <p>判断条件有三:</p>
     * <p>1.如果该元素自身满足移除条件(执行对应isRemovable方法)</p>
     * <p>2.超出界面上边界</p>
     * @param entity 待判断的实体
     * @return 可以移除返回true，否则返回false
     */
    public boolean isRemovable(T entity) {
        return entity.isRemovable() ||
                entity.getY() < -entity.getHeight();
    }

    /**
     * 将服务列表的每个实体在对应画板上进行绘制
     * @param g 需要绘制的画布的Graphics对象
     */
    @Override
    public void drawImage(Graphics g) {
        this.getEntityList().forEach(i -> i.drawImage(g));
    }

}
