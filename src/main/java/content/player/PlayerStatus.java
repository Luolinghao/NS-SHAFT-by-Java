package main.java.content.player;

import main.java.base.IDraw;
import main.java.constant.PlayerState;
import main.java.content.Attribute;

import java.awt.*;

public class PlayerStatus implements IDraw {
    private Attribute hp;

    private PlayerState status;
    private boolean haveShield = false;

    public boolean isHaveShield() {
        return haveShield;
    }

    public void setHaveShield(boolean haveShield) {
        this.haveShield = haveShield;
    }

    public PlayerStatus() {
        hp = new Attribute(10,0,10);
        status = PlayerState.STOP;
    }

    public Attribute getHp() {
        return hp;
    }

    @Override
    public void drawImage(Graphics g) {

    }

    public PlayerState getState() {
        return status;
    }

    public void setStatus(PlayerState status) {
        this.status = status;
    }
}
