package main.java.content.player;

import main.java.base.IDraw;
import main.java.constant.PlayerMovingState;
import main.java.content.Attribute;

import java.awt.*;

/**
 * 玩家状态类，实现了 {@link IDraw} 接口。
 */
public class PlayerStatus implements IDraw {

    private final Attribute hp;

    private int score;
    private int platformCount;

    private PlayerMovingState movingState;

    private boolean haveShield = false;

    /**
     * 获取玩家是否拥有护盾。
     *
     * @return 如果玩家拥有护盾，则返回 true；否则返回 false。
     */
    public boolean isHaveShield() {
        return haveShield;
    }

    /**
     * 设置玩家是否拥有护盾。
     *
     * @param haveShield 如果为 true，则表示玩家拥有护盾；如果为 false，则表示玩家没有护盾。
     */
    public void setHaveShield(boolean haveShield) {
        this.haveShield = haveShield;
    }

    /**
     * 玩家状态类的构造函数，初始化玩家的生命值和移动状态。
     */
    public PlayerStatus() {
        hp = new Attribute(10, 0, 10);
        movingState = PlayerMovingState.STOP;
    }

    /**
     * 获取玩家的生命值属性。
     *
     * @return 玩家的生命值属性。
     */
    public Attribute getHp() {
        return hp;
    }

    /**
     * 绘制玩家状态，但在此类中并未实现具体绘制逻辑。
     *
     * @param g 用于绘制的图形上下文。
     */
    @Override
    public void drawImage(Graphics g) {
        // 此处可以添加具体的绘制逻辑，根据需要进行实现
    }

    /**
     * 获取玩家的移动状态。
     *
     * @return 玩家的移动状态。
     */
    public PlayerMovingState getMovingState() {
        return movingState;
    }

    /**
     * 设置玩家的移动状态。
     *
     * @param movingState 要设置的移动状态。
     */
    public void setMovingState(PlayerMovingState movingState) {
        this.movingState = movingState;
    }

    /**
     * 获取玩家的当前积分。
     *
     * @return 玩家的当前积分。
     */
    public int getScore() {
        return this.score;
    }

    /**
     * 设置玩家的积分值。
     *
     * @param score 要设置的积分值。
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * 更新玩家的积分值。
     *
     * @param deltaScore 积分的增量值。
     */
    public void updateScore(int deltaScore) {
        this.score += deltaScore;
    }

    /**
     * 获取玩家的当前平台计数。
     *
     * @return 玩家的当前平台计数。
     */
    public int getPlatformCount() {
        return this.platformCount;
    }

    /**
     * 设置玩家的平台计数。
     *
     * @param platformCount 要设置的平台计数值。
     */
    public void setPlatformCount(int platformCount) {
        this.platformCount = platformCount;
    }

    /**
     * 更新玩家的平台计数，使其加一。
     */
    public void updatePlatformCount() {
        this.platformCount += 1;
    }
}
