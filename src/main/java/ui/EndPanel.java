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
        this.setLayout(null);//布局为空。防止setBounds失效

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
