package main.java.base;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 基础服务接口
 * <p>服务需对外提供的接口</p>
 * <p>继承IDraw接口，统一实现服务实体的绘制</p>
 * @param <T>本服务面向的对象类型
 */
public interface IBaseService<T> extends IDraw{

    /**
     * 服务初始化
     */
    void init();

    /**
     * 添加实体到服务列表
     * @param entity 服务面向的实体对象
     */
    void add(T entity);

    /**
     * 从服务列表移除对应实体
     * @param entity 待结束本服务的实体
     */
    void remove(T entity);

    /**
     * 获取本服务的服务列表
     * @return 服务实体列表
     */
    CopyOnWriteArrayList<T> getEntityList();

}
