package main.java.content.player;

import main.java.base.IDraw;
import main.java.constant.PlayerMovingState;
import main.java.content.Attribute;

import java.awt.*;

public class PlayerStatus implements IDraw {
    private Attribute hp;

    private PlayerMovingState status;

    public PlayerStatus() {
        hp = new Attribute(10,0,10);
        status = PlayerMovingState.STOP;
    }

    public Attribute getHp() {
        return hp;
    }

    @Override
    public void drawImage(Graphics g) {

    }

    public PlayerMovingState getState() {
        return status;
    }

    public void setStatus(PlayerMovingState status) {
        this.status = status;
    }
}
