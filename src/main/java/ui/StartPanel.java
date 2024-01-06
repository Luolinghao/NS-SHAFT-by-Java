package main.java.ui;

import main.java.constant.CommonUtils;
import main.java.constant.ConfigConstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 游戏开始界面画板，提供单人模式、双人模式和退出游戏的按钮。
 */
public class StartPanel extends JPanel {

    private final Image startBackgroundImage = CommonUtils.getImage("startbackground.jpg");
    private Image image;

    private final JButton singleMode;
    private final JButton doubleMode;
    private final JButton exit;

    /**
     * 绘制缓冲图像
     */
    private void drawBufferedImage() {
        image = this.createImage(this.getWidth(), this.getHeight());
        Graphics g = image.getGraphics();
        g.drawImage(startBackgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    /**
     * 构造函数
     *
     * @param gameFrame 游戏主窗体的引用
     */
    public StartPanel(GameFrame gameFrame) {
        this.setLayout(null); // 布局为空。防止 setBounds 失效

        // 单人模式按钮
        singleMode = new JButton("单人模式");
        singleMode.setFont(new Font("仿宋", Font.BOLD, 40));
        singleMode.setBounds(24 * 10, 500, 24 * 13, 24 * 2);
        singleMode.setBackground(Color.magenta);

        // 双人模式按钮
        doubleMode = new JButton("双人模式");
        doubleMode.setFont(new Font("仿宋", Font.BOLD, 40));
        doubleMode.setBounds(24 * 10, 600, 24 * 13, 24 * 2);
        doubleMode.setBackground(Color.CYAN);

        // 退出按钮
        exit = new JButton("退出游戏");
        exit.setFont(new Font("仿宋", Font.BOLD, 40));
        exit.setBounds(24 * 10, 700, 24 * 13, 24 * 2);
        exit.setBackground(Color.GREEN);

        // 单人模式按钮点击事件
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

        // 双人模式按钮点击事件
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

        // 退出按钮点击事件
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ConfigConstant.TIMER_ALL_STOP = true;
                gameFrame.removeAll();
                gameFrame.dispose();
            }
        });

        this.add(singleMode);
        this.add(doubleMode);
        this.add(exit);

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
