package main.java.constant;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.IOException;
import java.io.InputStream;

public enum Audio {

    BGM("BGM.wav"),
    GAME_OVER("gameOver.wav");


    Audio(String name) {
        this.name = name;
    }

    private String name;

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
