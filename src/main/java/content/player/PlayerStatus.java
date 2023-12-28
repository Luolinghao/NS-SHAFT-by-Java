package main.java.content.player;

import main.java.base.IDraw;
import main.java.constant.PlayerMovingState;
import main.java.constant.PlayerMovingState;
import main.java.content.Attribute;

import java.awt.*;

public class PlayerStatus implements IDraw {
    private Attribute hp;
    
    private int score;


    private PlayerMovingState movingState;

    private boolean haveShield = false;

    public boolean isHaveShield() {
        return haveShield;
    }

    public void setHaveShield(boolean haveShield) {
        this.haveShield = haveShield;
    }

    public PlayerStatus() {
        hp = new Attribute(10,0,10);
        movingState = PlayerMovingState.STOP;
    }

    public Attribute getHp() {
        return hp;
    }

    @Override
    public void drawImage(Graphics g) {

    }

    public PlayerMovingState getMovingState() {
        return movingState;
    }

    public void setMovingState(PlayerMovingState movingState) {
        this.movingState = movingState;
    }


    public int getScore() {
        return this.score;
    }

    /**
     * 修改积分的方法
     * @param score: 积分的值, 传入后将用该值覆盖角色的积分值
     * */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * 更新积分的方法
     * @param deltaScore: 积分增量*/
    public void updateScore(int deltaScore) {
        this.score += deltaScore;
    }
}
