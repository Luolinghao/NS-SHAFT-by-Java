package main.java.base;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 基础服务类
 * <p>在游戏中创建的实体对象通过服务类进行维护</p>
 * <p>不同的服务对应不同的服务类，新建服务继承本类</p>
 */
public abstract class BaseService<T> implements IBaseService<T>{

    /**
     * 本服务面向的实体列表
     * <p>考虑线程安全使用CopyOnWriteArrayList</p>
     */
    private final CopyOnWriteArrayList<T> entityList = new CopyOnWriteArrayList<>();

    /**
     * 服务初始化
     * <p>默认初始化服务列表为空</p>
     */
    @Override
    public void init(){
        this.entityList.clear();
    }

    /**
     * 获取本服务的服务列表
     * @return 服务实体列表
     */
    @Override
    public CopyOnWriteArrayList<T> getEntityList(){
        return entityList;
    }

    /**
     * 添加实体到服务列表
     * @param entity 服务面向的实体对象
     */
    @Override
    public void add(T entity) {
        entityList.add(entity);
    }

    /**
     * 从服务列表中移除该实体
     * @param entity 待结束本服务的实体
     */
    @Override
    public void remove(T entity) {
        entityList.remove(entity);
    }

    /**
     * 绘制方法
     * <p>负责绘制的服务需覆写本方法</p>
     * @param g 需要绘制的画布的Graphics对象
     */
    @Override
    public void drawImage(Graphics g){

    }
}
