package main.java.ui;



import main.java.base.IDraw;
import main.java.constant.CommonUtils;
import main.java.constant.ConfigConstant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

//初始界面画板
public class StartPanel extends JPanel {

    private Graphics startBuffer;
    private BufferedImage startbackground;
    private final Image startbackgroundImage = CommonUtils.getImage("startbackground.jpg");
    private Image image;
    private final IDraw[] draws;

    private final JButton singleMode;
    private final JButton doubleMode;

    private void drawBufferedImage() {
        /**
        *绘制开始界面背景图片
         */

        image = this.createImage(this.getWidth(), this.getHeight());
        Graphics g = image.getGraphics();
        g.drawImage(startbackgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);

        /**
         * 绘制
         */
        for (IDraw draw : this.draws) {
            draw.drawImage(g);
        }
    }


    public StartPanel(GameFrame gameFrame) {


        /**
         *   单人模式绘制按钮
         */
        this.setLayout(null);//布局为空。防止setBounds失效

        singleMode = new JButton("单人模式");
        singleMode.setFont(new Font("仿宋", Font.BOLD, 40));
        singleMode.setBounds(24 * 10, 500, 24 * 15, 24 * 2);
        singleMode.setBackground(Color.red);

        /**
         *  双人模式绘制按钮
         */
        this.setLayout(null);//布局为空。防止setBounds失效

        doubleMode = new JButton("双人模式");
        doubleMode.setFont(new Font("仿宋", Font.BOLD, 40));
        doubleMode.setBounds(24 * 10, 600, 24 * 15, 24 * 2);
        doubleMode.setBackground(Color.blue);

        /**
         *  单人模式
         */
        singleMode.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gameFrame.getStartPanel().setVisible(false);
                gameFrame.remove(gameFrame.getStartPanel());
                gameFrame.launch();
                gameFrame.requestFocus();
            }
        });

        /**
         *  双人模式
         */
        doubleMode.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ConfigConstant.GAME_MODE_TWO_PLAYER = true;
                gameFrame.getStartPanel().setVisible(false);
                gameFrame.remove(gameFrame.getStartPanel());
                gameFrame.launch();
                gameFrame.requestFocus();
            }
        });


        this.add(singleMode);
        this.add(doubleMode);

        gameFrame.add(this);

        gameFrame.setVisible(true);


        draws = new IDraw[0];
    }

    @Override

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        drawBufferedImage();
        g.drawImage(image, 0, 0, this);

    }

    public JButton getSingleMode() {
        return singleMode;
    }
}