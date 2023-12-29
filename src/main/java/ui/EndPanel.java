package main.java.ui;

import main.java.constant.CommonUtils;

import javax.swing.*;
import java.awt.*;

public class EndPanel extends JPanel {
    private Image image;

    private final Image endImage = CommonUtils.getImage("background.png");
    //结束图片

    /**
     * 构造函数
     */
    public EndPanel() {
        this.setBackground(Color.red);
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
