package main.java.service;
import main.java.base.BaseService;
import main.java.constant.PlatformConstant;
import main.java.content.platform.BasePlatform;
import main.java.content.player.Player;
import main.java.content.player.Player2;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class PlayerService extends BaseService<Player> {

    /**
     * 玩家服务单例
     */
    private static PlayerService singletonInstance;


    /**
     * 私有构造函数，禁止外部创建实例
     */
    private PlayerService(){}

    /**
     * 获取玩家服务单例
     * @return 玩家服务单例
     */
    public static synchronized PlayerService getSingletonInstance() {
        if(singletonInstance == null) {
            singletonInstance = new PlayerService();
        }
        return singletonInstance;
    }


    /**
     * 绘图
     * <p>负责绘制玩家及其信息</p>
     * @param g 需要绘制的画布的Graphics对象
     */
    @Override
    public void drawImage(Graphics g) {
        for (Player player : this.getEntityList()) {
            player.drawImage(g);
            playerMessageWrite(player,g);
        }
    }

    /**
     * 绘制玩家信息
     * @param player 待绘制信息的玩家
     * @param g 对应画板的画笔
     */
    private void playerMessageWrite(Player player, Graphics g) {

        //dy = 24*22  每个玩家信息y坐标差为24*22
        final int dy = (player.getPlayerNumber() - 1) * 24*22 ;

        //统一设置字体
        g.setFont(new Font("仿宋",Font.BOLD,40));
        //两种颜色的字，分别画,先画属性名称
        g.setColor(Color.RED);
        g.drawString("Player" + player.getPlayerNumber(),612,24*3 + dy);
        g.drawString("血量",24*26,24*7 + dy);
        g.drawString("层数",24*26,24*12 + dy);
        g.drawString("得分",24*26,24*17 + dy);

        //再画属性值
        g.setColor(Color.green);
        g.setFont(new Font("仿宋",Font.BOLD,40));
        g.drawString(String.valueOf(player.getPlayerStatus().getHp().getValue()),24*26,24*9 + dy);
        g.drawString(String.valueOf(PlatformConstant.PLATFORM_COUNT),24*26,24*14 + dy);
        g.drawString(String.valueOf(player.getPlayerStatus().getScore()),24*26,24*19 + dy);
    }



    public void update(){
        for(Player p :this.getEntityList()){
            if(p.isGameOver()){
                p.setRemovable(true);
                this.remove(p);
            }
        }
    }
    public boolean allGameOver(){
        int playerCount = this.getEntityList().size();

        for(Player p :this.getEntityList()){
            if(p.isGameOver()){
                playerCount--;
            }
        }
        if(playerCount == 0){
            return true;
        }
        return false;
    }



}
