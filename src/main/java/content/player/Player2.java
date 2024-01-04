package main.java.content.player;

import main.java.constant.*;

import java.awt.*;

/**
 * 第二玩家类，继承自 {@link Player} 类。
 */
public class Player2 extends Player {

    private final Image playerShield = CommonUtils.getImage("playerShield.gif");

    /**
     * 第二玩家类的构造函数，初始化玩家的位置、大小、速度等属性，并设置玩家编号为2。
     *
     * @param x 第二玩家的初始 x 坐标。
     * @param y 第二玩家的初始 y 坐标。
     */
    public Player2(int x, int y) {
        super(x, y);
        this.setPlayerNumber(2);
    }

    /**
     * 实现第二玩家在 X 轴上的移动逻辑。
     */
    @Override
    public void xMove() {
        // 左右键同时按下，不执行 X 轴移动
        if (Keys.LEFT_2.use() && Keys.RIGHT_2.use()) {
            this.getPlayerStatus().setMovingState(PlayerMovingState.STOP);
            return;
        }

        // 当没有按移动键时
        if (!(Keys.LEFT_2.use() || Keys.RIGHT_2.use())) {
            this.getPlayerStatus().setMovingState(PlayerMovingState.STOP);
            return;
        }

        // 左键
        if (Keys.LEFT_2.use()) {
            if (this.getX() > EntityConstant.WALL_LENGTH) {
                this.setX(this.getX() - this.getXSpeed());
            }
            this.getPlayerStatus().setMovingState(PlayerMovingState.LEFT_RUN);
            this.setDirection(Direction.LEFT);
        }

        // 右键
        if (Keys.RIGHT_2.use()) {
            if (this.getX() + this.getWidth() + EntityConstant.WALL_LENGTH < FrameConstant.FRAME_WIDTH - 24 * 11) {
                this.setX(this.getX() + this.getXSpeed());
            }
            this.getPlayerStatus().setMovingState(PlayerMovingState.RIGHT_RUN);
            this.setDirection(Direction.RIGHT);
        }

    }

    /**
     * 绘制第二玩家的图像，包括玩家状态、生命值等信息
     *
     * @param g 用于绘制的图形上下文。
     */
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
