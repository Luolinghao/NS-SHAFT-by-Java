package main.java.content.player;

import main.java.base.IDraw;
import main.java.constant.PlayerMovingState;
import main.java.constant.PlayerMovingState;
import main.java.content.Attribute;

import java.awt.*;

public class PlayerStatus implements IDraw {
    private Attribute hp;

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
}
