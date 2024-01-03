package main.java.content.player;

import main.java.base.BaseGravityEntity;
import main.java.constant.*;

import java.awt.*;

/**
 * 玩家类，继承自基础重力实体类 {@link BaseGravityEntity}。
 */
public class Player extends BaseGravityEntity {

    private final PlayerStatus playerStatus;
    private final Image playerShield = CommonUtils.getImage("playerShield.gif");

    private int playerNumber;

    /**
     * 玩家类的构造函数，初始化玩家的位置、大小、速度等属性。
     *
     * @param x 玩家的初始 x 坐标。
     * @param y 玩家的初始 y 坐标。
     */
    public Player(int x, int y) {
        super(x, y);
        this.setWidth(32);
        this.setHeight(32);
        this.setXSpeed(5);
        this.setYSpeed(0);
        this.setPlayerNumber(1);
        playerStatus = new PlayerStatus();
    }

    /**
     * 检查玩家是否游戏结束。
     *
     * @return 如果玩家的 Y 坐标超过窗口高度或玩家生命值为非正常状态，则返回 true，表示游戏结束。
     */
    public boolean isGameOver() {
        if (this.getY() > FrameConstant.FRAME_HEIGHT) {
            return true;
        }
        return !this.playerStatus.getHp().isNormal();
    }

    /**
     * 实现玩家在 X 轴上的移动逻辑。
     */
    @Override
    public void xMove() {
        // 左右键同时按下，不执行 X 轴移动
        if (Keys.LEFT.use() && Keys.RIGHT.use()) {
            this.getPlayerStatus().setMovingState(PlayerMovingState.STOP);
            return;
        }

        // 当没有按移动键时
        if (!(Keys.LEFT.use() || Keys.RIGHT.use())) {
            this.getPlayerStatus().setMovingState(PlayerMovingState.STOP);
            return;
        }

        // 左键
        if (Keys.LEFT.use()) {
            if (this.getX() > EntityConstant.WALL_LENGTH) {
                this.setX(this.getX() - this.getXSpeed());
            }
            this.getPlayerStatus().setMovingState(PlayerMovingState.LEFT_RUN);
            this.setDirection(Direction.LEFT);
        }

        // 右键
        if (Keys.RIGHT.use()) {
            if (this.getX() + this.getWidth() + EntityConstant.WALL_LENGTH < FrameConstant.FRAME_WIDTH - 24 * 11) {
                this.setX(this.getX() + this.getXSpeed());
            }
            this.getPlayerStatus().setMovingState(PlayerMovingState.RIGHT_RUN);
            this.setDirection(Direction.RIGHT);
        }
    }

    /**
     * 绘制玩家的图像，包括玩家状态、生命值等信息。
     *
     * @param g 用于绘制的图形上下文。
     */
    @Override
    public void drawImage(Graphics g) {
        super.drawImage(g);
        playerStatus.drawImage(g);
        if (this.getPlayerStatus().isHaveShield()) {
            g.drawImage(playerShield, getX(), getY(), getWidth(), getHeight(), null);
        }
    }

    /**
     * 获取玩家当前状态对应的图像。
     *
     * @return 玩家当前状态对应的图像。
     */
    @Override
    public Image getImage() {
        return this.playerStatus.getMovingState().getImage();
    }

    /**
     * 获取玩家的状态信息。
     *
     * @return 玩家的状态信息。
     */
    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    /**
     * 处理玩家受伤逻辑，根据护盾状态和伤害值进行相应的操作。
     *
     * @param hurtValue 伤害值。
     */
    public void beHurt(int hurtValue) {
        // 有护盾
        if (this.getPlayerStatus().isHaveShield()) {
            // 移除护盾
            this.getPlayerStatus().setHaveShield(false);
            // 直接返回，不进行受伤操作
            return;
        }

        // 受伤，生命减少
        this.getPlayerStatus().getHp().subtract(hurtValue);
    }

    /**
     * 获取玩家编号。
     *
     * @return 玩家编号。
     */
    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     * 设置玩家编号。
     *
     * @param playerNumber 要设置的玩家编号。
     */
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }
}
