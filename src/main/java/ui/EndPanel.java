package main.java.ui;

import main.java.constant.CommonUtils;
import main.java.constant.ConfigConstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EndPanel extends JPanel {


    private final Image endImage = CommonUtils.getImage("endImage.jpg");


    /**
     * 构造函数
     */
    public EndPanel(GameFrame gameFrame) {
        this.setLayout(null);//布局为空。防止setBounds失效

        this.setBounds(0,0,24*25,24*45);

        this.setBackground(Color.BLUE);


        Button restart = new Button("REPLAY");
        restart.setFont(new Font("仿宋", Font.BOLD, 40));
        restart.setBounds(24 * 10, 475, 24 * 15, 24 * 2);
        restart.setBackground(Color.RED);
        this.add(restart);

        Button home = new Button("MENU");
        home.setFont(new Font("仿宋", Font.BOLD, 40));
        home.setBounds(24 * 10, 600, 24 * 15, 24 * 2);
        home.setBackground(Color.RED);
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
        g.drawImage(endImage, 0, 0, 24*35,  24*45,this);
    }
}
