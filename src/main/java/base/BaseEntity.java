package main.java.base;

import main.java.constant.Direction;
import main.java.constant.EntityConstant;
import main.java.content.platform.BasePlatform;
import main.java.content.platform.SpikePlatform;

import java.awt.*;

/**
 * 基础实体类
 * <p>是游戏画面中所有实体对象的基类，规定实体所共有的属性与方法
 * <p>规定游戏实体必须有三种方法,显示，移动，相交判定
 * <p>显示即drawImage,移动即action,相交判定即intersects</p>
 */
public abstract class BaseEntity implements IDraw{

    /**
     * x坐标
     */
    private int x;

    /**
     * y坐标
     */
    private int y;

    /**
     * 高度
     */
    private int height;

    /**
     * 宽度
     */
    private int width;

    /**
     * 方向(实体朝向)
     */
    private Direction direction;

    /**
     * 水平速度
     */
    private int xSpeed;

    /**
     * 竖直速度
     */
    private int ySpeed;

    /**
     * 正面图片
     */
    private Image frontImage;

    /**
     * 判断本实体是否可以移除的标志
     */
    private boolean removable = false;

    public BaseEntity() {

    }

    public BaseEntity(int x, int y) {
        this.width = EntityConstant.NORMAL_ENTITY_SIZE;
        this.height = EntityConstant.NORMAL_ENTITY_SIZE;
        this.x = x;
        this.y = y;
        this.direction = Direction.FRONT;
    }

    /**
     * 显示方法
     * @param g 需要绘制的画布的Graphics对象
     */
    @Override
    public void drawImage(Graphics g) {
        g.drawImage(this.getImage(),this.x,this.y,this.width,this.height,null);
        //test
        g.setColor(Color.GREEN);
        g.drawRect(x,y,width,height);
    }

    /**
     * 获取图片
     * @return 正面图片
     */
    public Image getImage(){
        return frontImage;
    }

    /**
     * 移动方法
     */
    public void action(){
        this.xMove();
        this.yMove();
    }

    /**
     * 水平移动
     */
    public void xMove(){
        this.x += direction.isRight() ? xSpeed : -xSpeed;
    }

    /**
     * 竖直移动
     */
    public void yMove(){
        this.y += this.ySpeed;
    }

    /**
     * 相交判定
     * <p>碰撞体积默认为实体大小的矩形</p>
     * <p>采用AWT图形库中自带的intersects方法进行判定</p>
     * @return 如果相交返回ture否则返回false
     * @param <T>BaseEntity及其子类
     */
    public <T extends BaseEntity> boolean isIntersectsWith(T entity) {
        return this.getRectangle().intersects(entity.getRectangle());
    }

    /**
     * 获取矩形碰撞体积
     * @return Rectangle矩形碰撞体积
     */
    public Rectangle getRectangle(){
        return new Rectangle(this.x,this.y,this.width,this.height);
    }

    /**
     * 相交处理
     * @param other 另一个实体
     */
    public <T extends BaseEntity> void intersectsHandle(T other) {

    }

    public void moveWithPlatform(BasePlatform platform) {
        setYSpeed(platform.getYSpeed());
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setFrontImage(Image frontImage) {
        this.frontImage = frontImage;
    }

    public boolean isRemovable() {
        return removable;
    }

    public void setRemovable(boolean removable) {
        this.removable = removable;
    }
}
