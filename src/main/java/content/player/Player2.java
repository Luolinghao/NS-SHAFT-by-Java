package main.java.content.player;

import main.java.constant.*;

import java.awt.*;

public class Player2 extends Player{

    private final Image playerShield = CommonUtils.getImage("playerShield.gif");

    public Player2(int x, int y) {
        super(x, y);
        this.setPlayerNumber(2);
    }

    @Override
    public void xMove() {
        //左右键同时按下,不执行x轴移动
        if (Keys.LEFT_2.use() && Keys.RIGHT_2.use()) {
            this.getPlayerStatus().setMovingState(PlayerMovingState.STOP);
            return;
        }
        //当没有按移动键时
        if (!(Keys.LEFT_2.use() || Keys.RIGHT_2.use())) {
            this.getPlayerStatus().setMovingState(PlayerMovingState.STOP);
            return;
        }

        //左键
        if(Keys.LEFT_2.use()) {
            if(this.getX() > EntityConstant.WALL_LENGTH) {
                this.setX(this.getX() - this.getXSpeed());
            }
            this.getPlayerStatus().setMovingState(PlayerMovingState.LEFT_RUN);
            this.setDirection(Direction.LEFT);
        }

        if(Keys.RIGHT_2.use()) {
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
        //g.setColor(Color.WHITE);
        //g.drawRect(this.getX(),this.getY(),this.getWidth(),this.getHeight());
        if(this.getPlayerStatus().isHaveShield()) {
            g.drawImage(playerShield,getX(),getY(),getWidth(),getHeight(),null);
        }
    }

}
