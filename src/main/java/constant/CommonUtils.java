package main.java.constant;

import main.java.base.ITimer;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class CommonUtils {
    private static final Random RANDOM = new Random();//随机数

    /**
     * 获取在[start,end]间的整形随机数
     * <p>不进行区间合理性判定</p>
     * @param start 左边界
     * @param end 右边界
     * @return [start,end]间的整形随机数
     */
    public static int nextInt(int start, int end) {
        return start == end ? start : start + RANDOM.nextInt(end - start);
    }

    /**
     * 获取图片
     * @param imageName 图片名
     * @return 创建的Image对象
     */
    public static Image getImage(String imageName) {
        try {
            URL url = new URL(ConfigConstant.class.getResource(ConfigConstant.IMAGE_RESOURCES_PATH) + imageName);
            return new ImageIcon(url).getImage();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 开启一个指定周期的定时器
     * @param period 运行间隔
     * @param t 实现了ITimer接口，含有run方法的对象
     */
    public static void task(long period, ITimer t) {
        java.util.Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                //当结束开关打开时，清除所有定时器
                if (ConfigConstant.TIMER_ALL_STOP) {
                    timer.cancel();
                    return;
                }
                t.run();
            }
        };
        timer.schedule(timerTask, 0, period);
    }
}
