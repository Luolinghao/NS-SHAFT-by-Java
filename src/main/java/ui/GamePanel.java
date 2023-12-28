package main.java.ui;

import main.java.base.IDraw;
import main.java.constant.CommonUtils;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏画布类
 * <p>继承自JPanel类的自定义画布</p>
 */
public class GamePanel extends JPanel {
    /**
     * 待绘制的实体集合
     */
    private final IDraw[] draws;

    /**
     * 存放界面缓存
     */
    private Image image;

    /**
     * (游戏界面)背景图片
     */
    private final Image backgroundImage = CommonUtils.getImage("background.png");

    /**
     * GamePanel构造函数
     * <p>将需要更新显示的对象传入</p>
     * @param draws 所有需在本画板上更新的显示的对象
     */
    public GamePanel(IDraw... draws) {
        this.draws = draws;
    }

    /**
     * 绘制缓冲图片
     */
    private void drawBufferedImage() {
        image = this.createImage(this.getWidth(), this.getHeight());
        Graphics g = image.getGraphics();
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        //绘制
        for (IDraw draw : this.draws) {
            draw.drawImage(g);
        }
    }

    /**
     * paint方法
     * <p>游戏界面内容绘制</p>
     * @param g  the <code>Graphics</code> context in which to paint
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawBufferedImage();
        g.drawImage(image, 0, 0, this);
    }
}
