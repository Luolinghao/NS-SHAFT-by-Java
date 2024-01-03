package main.java.ui;



import main.java.constant.CommonUtils;
import main.java.constant.ConfigConstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//初始界面画板
public class StartPanel extends JPanel {

    private final Image startbackgroundImage = CommonUtils.getImage("startbackground.jpg");
    private Image image;


    private final JButton singleMode;
    private final JButton doubleMode;
    private final JButton out;

    private void drawBufferedImage() {


        image = this.createImage(this.getWidth(), this.getHeight());
        Graphics g = image.getGraphics();
        g.drawImage(startbackgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);


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
         * 退出按钮绘制
         */
        this.setLayout(null);//布局为空。防止setBounds失效

        out = new JButton("退出游戏");
        out.setFont(new Font("仿宋", Font.BOLD, 40));
        out.setBounds(24 * 10, 700, 24 * 15, 24 * 2);
        out.setBackground(Color.green);

        /**
         *  单人模式
         */
        singleMode.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ConfigConstant.GAME_MODE_TWO_PLAYER = false;
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

        /**
         *  退出游戏
         */
        out.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ConfigConstant.TIMER_ALL_STOP = true;
                gameFrame.removeAll();
                gameFrame.dispose();
            }
        });

        this.add(singleMode);
        this.add(doubleMode);
        this.add(out);

        gameFrame.add(this);

        gameFrame.setVisible(true);


    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        drawBufferedImage();
        g.drawImage(image, 0, 0, this);

    }

}