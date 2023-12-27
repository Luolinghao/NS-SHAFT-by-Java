package main.java.content.platform;

import main.java.base.BaseEntity;
import main.java.constant.Direction;
import main.java.constant.PlatformConstant;
import main.java.constant.PlatformType;
import main.java.content.substance.Prop;

import java.awt.*;

public abstract class BasePlatform extends BaseEntity {

    private PlatformType type;

    private Prop prop;

    /**
     * BasePlatform的构造函数
     * <p>初始化平台x,y坐标以及宽高和朝向</p>
     * @param x x坐标
     * @param y y坐标
     */
    public BasePlatform(int x,int y) {
        this.setYSpeed(-5);
        this.setX(x);
        this.setY(y);
        this.setHeight(PlatformConstant.HEIGHT);
        this.setWidth(PlatformConstant.WIDTH);
        this.setDirection(Direction.FRONT);
    }

    /**
     * 判断某实体是否在本实体上方与本实体相交
     * @param otherEntity 另一个实体
     * @return 相交返回ture否则返回false
     * @param <T> BaseEntity及其子类
     */
    public <T extends BaseEntity> boolean isAboveIntersectsWith(T otherEntity) {
        Rectangle myself = this.getRectangle();
        Rectangle otherEntityRectangle = otherEntity.getRectangle();

        return otherEntityRectangle.getY() < myself.getY() &&
                myself.intersects(otherEntityRectangle);
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(), getY() - 5, getWidth(), getHeight());
    }

    public PlatformType getType() {
        return type;
    }

    public void setType(PlatformType type) {
        this.type = type;
    }

    public Prop getProp() {
        return prop;
    }

    public void setProp(Prop prop) {
        this.prop = prop;
    }
}
