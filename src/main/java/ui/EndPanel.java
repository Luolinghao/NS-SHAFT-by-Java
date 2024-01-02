package main.java.ui;

import main.java.constant.CommonUtils;

import javax.swing.*;
import java.awt.*;

public class EndPanel extends JPanel {


    private final Image endImage = CommonUtils.getImage("gameover.jpg");
    /**
     * 绘制结束界面图片
     */

    /**
     * 构造函数
     */
    public EndPanel() {
        this.setBounds(0,0,24*25,24*45);
        this.setVisible(true);
        JLabel jLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(endImage);
        jLabel.setSize(24*25,24*45);
        jLabel.setIcon(imageIcon);
        this.add(jLabel);
        this.repaint();
    }

}
