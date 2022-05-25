package enums;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public enum Musics {
    MENU(new MediaPlayer(new Media(new File("src/main/resources/musics/desert_loops_2.mp3").toURI().toString()))),
    GAME(new MediaPlayer(new Media(new File("src/main/resources/musics/bensound-goinghigher.mp3").toURI().toString()))),
    BOMB(new MediaPlayer(new Media(new File("src/main/resources/musics/bomb.mp3").toURI().toString()))),
    SHOT(new MediaPlayer(new Media(new File("src/main/resources/musics/gun.mp3").toURI().toString()))),
    BOSS1(new MediaPlayer(new Media(new File("src/main/resources/musics/laugh.mp3").toURI().toString()))),
    BOSS2(new MediaPlayer(new Media(new File("src/main/resources/musics/boss2.mp3").toURI().toString())));


    private final MediaPlayer mediaPlayer;

    Musics(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
}
