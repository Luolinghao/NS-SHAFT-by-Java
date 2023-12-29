package main.java.constant;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {

    public Mouse(){

    }

    @Override
    public void mouseClicked(MouseEvent e){
        ConfigConstant.START = true;

    }
}
