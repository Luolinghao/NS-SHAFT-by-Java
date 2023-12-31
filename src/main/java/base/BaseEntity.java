package main.java.base;

import main.java.constant.Direction;
import main.java.constant.EntityConstant;
import main.java.content.platform.BasePlatform;

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

    /**
     * 空构造函数
     */
    public BaseEntity() {}

    /**
     * BaseEntity构造函数
     * <p>初始化默认宽高，朝向以及左顶点坐标</p>
     * @param x 左顶点x坐标
     * @param y 左顶点y坐标
     */
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
     * <p>需要执行相交处理的类需要覆写本方法</p>
     * @param other 另一个实体
     */
    public <T extends BaseEntity> void intersectsHandle(T other) {}

    /**
     * 跟随平台移动
     * <p>将本实体的y速度设置为平台的速度</p>
     * @param platform 跟随的平台
     */
    public void moveWithPlatform(BasePlatform platform) {
        setYSpeed(platform.getYSpeed());
    }

    /**
     * 获取左上顶点x坐标
     * @return 左上顶点x坐标值
     */
    public int getX() {
        return x;
    }

    /**
     * 设置左上顶点x坐标
     * @param x 左上顶点x坐标
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * 获取左上顶点y坐标
     * @return 左上顶点y坐标值
     */
    public int getY() {
        return y;
    }

    /**
     * 设置左上顶点y坐标
     * @param y 左上顶点y坐标
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * 获得对象高度
     * @return 对象高度的值
     */
    public int getHeight() {
        return height;
    }

    /**
     * 设置对象高度的值
     * @param height 对象的高度
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 获取对象宽度的值
     * @return 对象宽度的值
     */
    public int getWidth() {
        return width;
    }

    /**
     * 设置对象宽度的值
     * @param width 对象的宽度
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * 获取对象的朝向
     * @return 对象的朝向
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * 设置对象的朝向
     * @param direction 对象朝向
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * 获取对象的x轴速度值
     * @return x轴速度值
     */
    public int getXSpeed() {
        return xSpeed;
    }

    /**
     * 设置对象x轴速度
     * @param xSpeed x轴速度
     */
    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    /**
     * 获取对象的y轴速度值
     * @return y轴速度值
     */
    public int getYSpeed() {
        return ySpeed;
    }

    /**
     * 设置对象y轴速度
     * @param ySpeed y轴速度
     */
    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    /**
     * 设置对象正面图片
     * @param frontImage 对象的正面图片
     */
    public void setFrontImage(Image frontImage) {
        this.frontImage = frontImage;
    }

    /**
     * 判定本对象是否满足移除条件
     * @return 可以移除返回true,否则返回false
     */
    public boolean isRemovable() {
        return removable;
    }

    /**
     * 设置可移除变量的布尔值
     * @param removable true or false
     */
    public void setRemovable(boolean removable) {
        this.removable = removable;
    }
}
