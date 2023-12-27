package main.java.content.player;

import main.java.base.BaseGravityEntity;
import main.java.constant.*;

import java.awt.*;

public class Player extends BaseGravityEntity {

    private PlayerStatus playerStatus;

    public Player(int x, int y) {
        super(x, y);
        this.setWidth(32);
        this.setHeight(32);
        this.setXSpeed(5);
        this.setYSpeed(0);
        playerStatus = new PlayerStatus();
    }

    public  boolean isGameOver() {
        if(this.getY() > FrameConstant.FRAME_HEIGHT) {

            return true;
        }

        return !this.playerStatus.getHp().isNormal();
    }

    @Override
    public void action() {
        super.action();
        //System.out.println(getX() + "," + getY());
    }

    @Override
    public void xMove() {
        //左右键同时按下,不执行x轴移动
        if (Keys.LEFT.use() && Keys.RIGHT.use()) {
            this.getPlayerStatus().setStatus(PlayerMovingState.STOP);
            return;
        }
        //当没有按移动键时
        if (!(Keys.LEFT.use() || Keys.RIGHT.use())) {
            this.getPlayerStatus().setStatus(PlayerMovingState.STOP);
            return;
        }

        //左键
        if(Keys.LEFT.use()) {
            if(this.getX() > EntityConstant.WALL_LENGTH) {
                this.setX(this.getX() - this.getXSpeed());
            }
            this.getPlayerStatus().setStatus(PlayerMovingState.LEFT_RUN);
            this.setDirection(Direction.LEFT);
        }
        if(Keys.RIGHT.use()) {
            if(this.getX() + this.getWidth() + EntityConstant.WALL_LENGTH < FrameConstant.FRAME_WIDTH) {
                this.setX(this.getX() + this.getXSpeed());
            }
            this.getPlayerStatus().setStatus(PlayerMovingState.RIGHT_RUN);
            this.setDirection(Direction.RIGHT);
        }

    }

    @Override
    public void yMove() {
        super.yMove();
    }

    @Override
    public void drawImage(Graphics g) {
        super.drawImage(g);
        playerStatus.drawImage(g);
    }

    @Override
    public Image getImage() {
        return this.playerStatus.getState().getImage();
    }


    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void beHurt(int hurtValue) {
        //有护盾





        //受伤，生命减少
        this.getPlayerStatus().getHp().subtract(hurtValue);
    }
}
