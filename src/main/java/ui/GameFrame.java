package main.java.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.java.constant.*;
import main.java.content.player.Player;
import main.java.generator.PlatformGenerator;
import main.java.service.Service;

public class GameFrame extends JFrame {

    public GameFrame(){
        //设置窗体标题
        this.setTitle("100");
        //默认关闭
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体不可变
        this.setResizable(false);//固定窗体
        //设置窗体居中
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension size = new Dimension(FrameConstant.FRAME_WIDTH, FrameConstant.FRAME_HEIGHT);
        int width = toolkit.getScreenSize().width;
        int height = toolkit.getScreenSize().height;
        this.setBounds((int) (width - size.getWidth()) / 2,
                (int) (height - size.getHeight()) / 3, (int) size.getWidth(), (int) size.getHeight());
    }

    public void launch(){
        //主界面

        //当开始游戏时
        //初始化游戏服务,对每种服务进行初始化
        Service.init();
        //创建玩家
        Player player = new Player(100,100);
        //将玩家加入重力服务集合
        Service.gravity.add(player);
        //刷新每个实体的动作
        CommonUtils.task(25, () -> {
            player.action();

            entityServiceUpdateWith(player);

            Service.gravity.update();
            Service.platform.groundJudge(player);
        });
        //生成道具与平台
        CommonUtils.task(1000, () -> {
            Service.platform.add(PlatformGenerator.build());
        });
        //音乐
        CommonUtils.task(30 * 1000, Audio.BGM::play);
        //创建画板
        GamePanel gamePanel = new GamePanel(player,Service.platform,Service.substance);
        //显示窗体
        this.add(gamePanel);
        this.setVisible(true);

        //更新面板
        CommonUtils.task(5, () -> {
            if (player.isGameOver()) {
                ConfigConstant.TIMER_ALL_STOP = true;
                Audio.GAME_OVER.play();
                try {
                    Thread.sleep( 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.dispose();
                System.exit(0);//此处可以替换为打开新的窗体等
            }
            gamePanel.repaint();
        });

        //玩家键盘监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Keys.add(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                Keys.remove(e.getKeyCode());
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX() + "," + e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }
        });
    }

    public void entityServiceUpdateWith(Player player) {
        Service.platform.update(player);
        Service.substance.update(player);
    }

    public static void main(String[] args)  {
        GameFrame gameFrame = new GameFrame();
        gameFrame.launch();
    }
}