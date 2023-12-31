package main.java.constant;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.IOException;
import java.io.InputStream;

/**
 * 音乐枚举类
 * <p>存储所有游戏中可能会用到的音乐</p>
 */
public enum Audio {

    BGM("BGM.wav"),
    GAME_OVER("gameOver.wav");

    /**
     * Audio构造函数
     * <p>为每个音乐设置对应文件名</p>
     * @param name 音乐名
     */
    Audio(String name) {
        this.name = name;
    }

    /**
     * 音乐对应文件名
     */
    private final String name;

    /**
     * 播放本音乐
     */
    public void play() {
        AudioStream as = null;
        try {
            InputStream resourceAsStream = Audio.class.getClassLoader().getResourceAsStream("main/resources/audio/" + name);
            if (resourceAsStream != null) {
                as = new AudioStream(resourceAsStream);
            }
            AudioPlayer.player.start(as);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
