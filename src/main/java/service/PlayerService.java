package main.java.service;
import main.java.base.BaseService;
import main.java.content.platform.BasePlatform;
import main.java.content.player.Player;

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

    @Override
    public void drawImage(Graphics g) {
        for (Player player : this.getEntityList()) {
            player.drawImage(g);
        }
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
