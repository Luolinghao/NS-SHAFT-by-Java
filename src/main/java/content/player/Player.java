package main.java.content.player;

import main.java.base.BaseGravityEntity;
import main.java.constant.*;

import java.awt.*;

public class Player extends BaseGravityEntity {

    private final PlayerStatus playerStatus;
    private final Image playerShield = CommonUtils.getImage("playerShield.gif");

    private int playerNumber;

    public Player(int x, int y) {
        super(x, y);
        this.setWidth(32);
        this.setHeight(32);
        this.setXSpeed(5);
        this.setYSpeed(0);
        this.setPlayerNumber(1);
        playerStatus = new PlayerStatus();
    }

    public  boolean isGameOver() {
        if(this.getY() > FrameConstant.FRAME_HEIGHT) {

            return true;
        }

        return !this.playerStatus.getHp().isNormal();
    }


    @Override
    public void xMove() {
        //左右键同时按下,不执行x轴移动
        if (Keys.LEFT.use() && Keys.RIGHT.use()) {
            this.getPlayerStatus().setMovingState(PlayerMovingState.STOP);
            return;
        }
        //当没有按移动键时
        if (!(Keys.LEFT.use() || Keys.RIGHT.use())) {
            this.getPlayerStatus().setMovingState(PlayerMovingState.STOP);
            return;
        }

        //左键
        if(Keys.LEFT.use()) {
            if(this.getX() > EntityConstant.WALL_LENGTH) {
                this.setX(this.getX() - this.getXSpeed());
            }
            this.getPlayerStatus().setMovingState(PlayerMovingState.LEFT_RUN);
            this.setDirection(Direction.LEFT);
        }

        if(Keys.RIGHT.use()) {
            if(this.getX() + this.getWidth() + EntityConstant.WALL_LENGTH < FrameConstant.FRAME_WIDTH - 24*11) {
                this.setX(this.getX() + this.getXSpeed());
            }
            this.getPlayerStatus().setMovingState(PlayerMovingState.RIGHT_RUN);
            this.setDirection(Direction.RIGHT);
        }

    }


    @Override
    public void drawImage(Graphics g) {
        super.drawImage(g);
        playerStatus.drawImage(g);
        if(this.getPlayerStatus().isHaveShield()) {
            g.drawImage(playerShield,getX(),getY(),getWidth(),getHeight(),null);
        }
    }

    @Override
    public Image getImage() {
        return this.playerStatus.getMovingState().getImage();
    }


    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void beHurt(int hurtValue) {
        //有护盾
        if(this.getPlayerStatus().isHaveShield()) {
            //移除护盾
            this.getPlayerStatus().setHaveShield(false);
            //直接返回，不进行受伤操作
            return;
        }

        //受伤，生命减少
        this.getPlayerStatus().getHp().subtract(hurtValue);
    }



    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }
}
