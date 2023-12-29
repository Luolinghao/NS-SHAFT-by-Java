package main.java.ui;



import main.java.constant.ConfigConstant;
import main.java.constant.Keys;

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

    private Image image;

    private ImageIcon imageIcon;

    private JButton singleMode;
    private JButton doubleMode;

    public StartPanel(GameFrame gameFrame){
        startImage=new BufferedImage(24*25,24*45,BufferedImage.TYPE_INT_RGB);
        startBuffer=startImage.getGraphics();
        this.setLayout(null);

        //绘制文字
        startBuffer.setColor(Color.RED);
        startBuffer.setFont(new Font("仿宋",Font.BOLD,100));
        startBuffer.drawString("地狱一百层",24*10,24*5);

        //单人模式绘制按钮
        singleMode = new JButton("单人模式");
        singleMode.setFont(new Font("仿宋",Font.BOLD,40));
        singleMode.setBounds(24*10,500,24*15,24*2);
        singleMode.setBackground(Color.blue);
        
        //双人模式绘制按钮
        doubleMode = new JButton("双人模式");
        doubleMode.setFont(new Font("仿宋",Font.BOLD,40));
        doubleMode.setBounds(24*10,600,24*15,24*2);
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

    public JButton getsingleMode(){
        return singleMode;
    }








}
