package main.java.ui;



import main.java.constant.Keys;
import main.java.constant.Mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

//初始界面画板
public class StartPanel extends JPanel {

    //java.net.URL st=getClass().getResource("")
    private BufferedImage startImage;
    private Graphics startBuffer;

    //private ImageIcon started=new ImageIcon();;

    private JButton j1;

    public StartPanel(GameFrame gameFrame){
        this.setBackground(Color.white);
        startImage=new BufferedImage(24*25,24*45,BufferedImage.TYPE_INT_RGB);
        startBuffer=startImage.getGraphics();
        this.setLayout(null);

        //绘制文字
        startBuffer.setColor(Color.white);
        startBuffer.setFont(new Font("宋体",Font.BOLD,36));
        startBuffer.drawString("地狱一百层",100,100);

        //绘制按钮
        j1=new JButton("开始游戏");
        j1.setBounds(150,300,100,50);
        j1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gameFrame.getStartPanel().setVisible(false);
                gameFrame.remove(gameFrame.getStartPanel());
                gameFrame.launch();
                gameFrame.requestFocus();
            }
        });


        this.add(j1);

        gameFrame.add(this);

        gameFrame.setVisible(true);


    }

    public JButton getJ1(){
        return j1;
    }








}
