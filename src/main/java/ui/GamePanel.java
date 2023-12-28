package main.java.ui;

import main.java.base.IDraw;
import main.java.constant.CommonUtils;
import main.java.content.player.Player;

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
    private final Image leftboundImage = CommonUtils.getImage("wall.png");
    private final Image rightboundImage = CommonUtils.getImage("wall.png");
    private final Image ceilingImage = CommonUtils.getImage("ceiling.png");
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
        g.drawImage(ceilingImage, 0, 0, this.getWidth()-264, 20, this);
        g.drawImage(leftboundImage, 0, 0, 24, this.getHeight(), this);
        g.drawImage(rightboundImage, this.getWidth()-264, 0, 24, this.getHeight(), this);
        //绘制
        for (IDraw draw : this.draws) {
            draw.drawImage(g);
        }
        for (IDraw draw : this.draws) {
            if(draw instanceof Player){
                wordWrite((Player) draw);
            }
        }
    }

    private void wordWrite(Player player){
        Graphics pen1 = image.getGraphics();
        Graphics pen2 = image.getGraphics();
        pen1.setColor(Color.RED);
        pen1.setFont(new Font("仿宋",Font.BOLD,40));
        pen2.setColor(Color.green);
        pen2.setFont(new Font("仿宋",Font.BOLD,40));
        pen1.drawString("血量",24*26,24*10);
        pen2.drawString(String.valueOf(player.getPlayerStatus().getHp().getValue()),24*26,24*15);
        pen1.drawString("层数",24*26,24*20);
        pen2.drawString(String.valueOf(player.getPlayerStatus().getPlatformCount()),24*26,24*25);
        pen1.drawString("得分",24*26,24*30);
        pen2.drawString(String.valueOf(player.getPlayerStatus().getScore()),24*26,24*35);
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
