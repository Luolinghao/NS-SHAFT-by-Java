package main.java.ui;

import main.java.constant.CommonUtils;
import main.java.constant.ConfigConstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 游戏结束面板，显示游戏结束界面并提供重新开始和返回菜单的按钮。
 */
public class EndPanel extends JPanel {

    private final Image endImage = CommonUtils.getImage("endImage.jpg");

    /**
     * 构造函数
     *
     * @param gameFrame 游戏主窗体的引用
     */
    public EndPanel(GameFrame gameFrame) {
        this.setLayout(null); // 布局为空。防止 setBounds 失效

        this.setBounds(0, 0, 24 * 25, 24 * 45);
        this.setBackground(Color.BLUE);

        Button restart = new Button("REPLAY");
        restart.setFont(new Font("仿宋", Font.BOLD, 40));
        restart.setBounds(24 * 10, 420, 24 * 15, 24 * 2);
        restart.setBackground(Color.BLUE);
        this.add(restart);

        Button home = new Button("MENU");
        home.setFont(new Font("仿宋", Font.BOLD, 40));
        home.setBounds(24 * 10, 520, 24 * 15, 24 * 2);
        home.setBackground(Color.BLUE);
        this.add(home);

        restart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ConfigConstant.TIMER_ALL_STOP = false;
                gameFrame.getEndPanel().setVisible(false);
                gameFrame.remove(gameFrame.getEndPanel());
                gameFrame.launch();
                gameFrame.requestFocus();
            }
        });

        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ConfigConstant.TIMER_ALL_STOP = false;
                gameFrame.getEndPanel().setVisible(false);
                gameFrame.remove(gameFrame.getEndPanel());
                gameFrame.startPanel();
                gameFrame.requestFocus();
            }
        });

        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(endImage, 0, 0, 24 * 35, 24 * 45, this);
    }
}
