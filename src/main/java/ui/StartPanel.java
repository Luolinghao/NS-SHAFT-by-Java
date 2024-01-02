package main.java.ui;



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
    java.net.URL st = getClass().getResource("startbackground.jpg");
    private ImageIcon started = new ImageIcon(st);

    private final JButton singleMode;
    private final JButton doubleMode;


    public StartPanel(GameFrame gameFrame) {

        startbackground = new BufferedImage(this.getWidth(),this.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        startBuffer = startbackground.getGraphics();
        startBuffer.drawImage(started.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);


        //绘制文字
        startBuffer.setColor(Color.RED);
        startBuffer.setFont(new Font("仿宋", Font.BOLD, 100));
        startBuffer.drawString("地狱一百层", 24 * 10, 24 * 5);

        //单人模式绘制按钮
        singleMode = new JButton("单人模式");
        singleMode.setFont(new Font("仿宋", Font.BOLD, 40));
        singleMode.setBounds(24 * 10, 500, 24 * 15, 24 * 2);
        singleMode.setBackground(Color.blue);

        //双人模式绘制按钮
        doubleMode = new JButton("双人模式");
        doubleMode.setFont(new Font("仿宋", Font.BOLD, 40));
        doubleMode.setBounds(24 * 10, 600, 24 * 15, 24 * 2);
        doubleMode.setBackground(Color.blue);

        //单人模式
        singleMode.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gameFrame.getStartPanel().setVisible(false);
                gameFrame.remove(gameFrame.getStartPanel());
                gameFrame.launch();
                gameFrame.requestFocus();
            }
        });

        //双人模式
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


    }

    @Override

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawImage(startbackground, 0, 0, this.getWidth(), this.getHeight(), null);

    }

    public JButton getSingleMode() {
        return singleMode;
    }
}