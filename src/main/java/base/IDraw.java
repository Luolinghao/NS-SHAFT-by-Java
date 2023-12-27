package main.java.base;

import java.awt.*;

/**
 * 绘图接口
 * <p>能够显示的对象对外应提供的接口</p>
 */
public interface IDraw {
        /**
         * 绘制图像
         * @param g 需要绘制的画布的Graphics对象
         */
        void drawImage(Graphics g);
}
