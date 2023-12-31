package main.java.base;

/**
 * 计时器接口
 * <p>需要定时执行的操作需要对外提供的接口</p>
 */
public interface ITimer {
    /**
     * 待周期执行的任务
     */
    void run();
}
