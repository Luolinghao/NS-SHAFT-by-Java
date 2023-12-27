package main.java.ui;

import main.java.base.IDraw;
import main.java.constant.CommonUtils;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final IDraw[] draws;//待绘制的元素
    private Image image;//缓冲
    private final Image backgroundImage = CommonUtils.getImage("background.png");//背景图片

    /**
     * Panel构造函数
     * <p>将需要更新显示的对象传入</p>
     * @param draws 所有需在本画板上更新的显示的对象
     */
    public GamePanel(IDraw... draws) {
        this.draws = draws;
    }

    /**
     * 绘制缓冲
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

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawBufferedImage();
        g.drawImage(image, 0, 0, this);
    }
}
