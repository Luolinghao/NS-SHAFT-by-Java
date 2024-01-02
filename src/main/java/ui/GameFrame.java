package main.java.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.java.constant.*;
import main.java.content.platform.Ceiling;
import main.java.content.platform.NormalPlatform;
import main.java.content.player.Player;
import main.java.content.player.Player2;
import main.java.generator.PlatformGenerator;
import main.java.service.Service;

/**
 * 游戏界面类
 */
public class GameFrame extends JFrame {
    private StartPanel startPanel;

    private EndPanel endPanel;
    StartPanel sp;

    /**
     * 游戏界面的构造函数
     * <p>进行初始化界面配置</p>
     */
    public GameFrame(){
        //设置窗体标题
        this.setTitle("地狱一百层");
        //默认关闭
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体不可变
        this.setResizable(false);
        //固定窗体
        //设置窗体居中
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension size = new Dimension(FrameConstant.FRAME_WIDTH, FrameConstant.FRAME_HEIGHT);
        int width = toolkit.getScreenSize().width;
        int height = toolkit.getScreenSize().height;
        this.setBounds((int) (width - size.getWidth()) / 2 ,
                (int) (height - size.getHeight()) / 3, (int) size.getWidth(), (int) size.getHeight());

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
    }


    //绘制初始界面画板
    public void startPanel() {
        startPanel = new StartPanel(this);
    }

    public void endPanel(){
        endPanel = new EndPanel();
    }

    /**
     * 游戏程序运行的主体逻辑
     */
    public void launch(){
        //主界面

        //当开始游戏时
        //初始化游戏服务,对每种服务进行初始化
        Service.init();
        //创建玩家
        Player player1 = new Player(100,100);
        Player2 player2 = new Player2(150,100);

        //创建天花板
        Ceiling ceiling = new Ceiling();
        //创建初始平台
        NormalPlatform platform = new NormalPlatform(100,100 + 300);
        //将玩家加入重力服务集合和玩家服务集合
        Service.gravity.add(player1);
        Service.players.add(player1);
        if(ConfigConstant.GAME_MODE_TWO_PLAYER) {
            Service.gravity.add(player2);
            Service.players.add(player2);

        }
        Service.platform.add(ceiling);
        Service.platform.add(platform);


        //音乐
        CommonUtils.task(30 * 1000, Audio.BGM::play);
        //创建画板
        GamePanel gamePanel = new GamePanel(Service.players,Service.platform,Service.substance);
        //显示窗体
        this.add(gamePanel);
        this.setVisible(true);

        CommonUtils.task(25,() -> {
            for(Player p : Service.players.getEntityList()){
                Service.platform.groundJudge(p);
            }
            entityServiceUpdateWith(player1,player2);

            Service.gravity.update();

            player1.action();
            player2.action();



            Service.players.update();
        });
        //更新面板
        CommonUtils.task(5, () -> {

            gamePanel.repaint();
            if (Service.players.allGameOver()) {
                ConfigConstant.TIMER_ALL_STOP = true;
                Audio.GAME_OVER.play();
                try {
                    Thread.sleep( 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gamePanel.setVisible(false);
                this.remove(gamePanel);
                //删除已有画板
                this.endPanel();
                endPanel.setVisible(true);
                this.add(endPanel);
                this.revalidate();
                this.repaint();
            }

        });

        //生成道具与平台
        CommonUtils.task(1000, () -> {
            Service.platform.add(PlatformGenerator.build());
            for(Player p : Service.players.getEntityList()){
                p.getPlayerStatus().updateScore(1);
            }

        });

        //玩家键盘监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Keys.add(e.getKeyCode());
                System.out.println("a USED");
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

    /**
     * 面向实体对象的服务更新
     * @param players 玩家集合
     */
    public void entityServiceUpdateWith(Player... players) {
        Service.platform.update(players);
        Service.substance.update(players);

    }

    public StartPanel getStartPanel(){
        return startPanel;
    }

    public EndPanel getEndPanel(){
        return endPanel;
    }

    /**
     * 程序入口
     * @param args 初始参数
     */
    public static void main(String[] args)  {
        GameFrame gameFrame = new GameFrame();
        gameFrame.startPanel();
    }
}
