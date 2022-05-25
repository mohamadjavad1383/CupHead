package controllers;

import enums.Musics;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class MusicController {
    private static MusicController instance = null;

    private MediaPlayer menuPlayer, gamePlayer;

    private MusicController() {
    }

    public static MusicController getInstance() {
        if (instance == null)
            instance = new MusicController();
        return instance;
    }

    public void playMusic() {

        menuPlayer = Musics.MENU.getMediaPlayer();
        gamePlayer = Musics.GAME.getMediaPlayer();

        menuPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                menuPlayer.seek(Duration.ZERO);
            }
        });

        gamePlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                gamePlayer.seek(Duration.ZERO);
            }
        });

        /*
        menuPlayer.play();
        gamePlayer.setMute(true);
        gamePlayer.play();
        */
    }


    public void changeMusic() {
        if (!menuPlayer.isMute()) {
            menuPlayer.setMute(true);
            gamePlayer.setMute(false);
        } else {
            gamePlayer.setMute(true);
            menuPlayer.setMute(false);
        }
    }

    // TODO add other media's
    public void mute() {
        if (!Musics.MENU.getMediaPlayer().isMute()) {
            Musics.MENU.getMediaPlayer().setMute(true);
            Musics.GAME.getMediaPlayer().setMute(true);
            Musics.SHOT.getMediaPlayer().setMute(true);
            Musics.BOMB.getMediaPlayer().setMute(true);
            Musics.BOSS1.getMediaPlayer().setMute(true);
            Musics.BOSS2.getMediaPlayer().setMute(true);

        } else {
            Musics.MENU.getMediaPlayer().setMute(false);
            Musics.GAME.getMediaPlayer().setMute(false);
            Musics.SHOT.getMediaPlayer().setMute(false);
            Musics.BOMB.getMediaPlayer().setMute(false);
            Musics.BOSS1.getMediaPlayer().setMute(false);
            Musics.BOSS2.getMediaPlayer().setMute(false);
        }
    }

    public void muteInGame() {
        Musics.GAME.getMediaPlayer().setMute(!Musics.GAME.getMediaPlayer().isMute());
        Musics.SHOT.getMediaPlayer().setMute(!Musics.SHOT.getMediaPlayer().isMute());
        Musics.BOMB.getMediaPlayer().setMute(!Musics.BOMB.getMediaPlayer().isMute());
    }

    public void Bomb() {
        Musics.BOMB.getMediaPlayer().play();
        Musics.BOMB.getMediaPlayer().setOnEndOfMedia(() -> Musics.BOMB.getMediaPlayer().stop());
    }

    public void shot() {
        Musics.SHOT.getMediaPlayer().play();
        Musics.SHOT.getMediaPlayer().setOnEndOfMedia(() -> Musics.SHOT.getMediaPlayer().stop());
    }

    public void boss1() {
        Musics.BOSS1.getMediaPlayer().play();
        Musics.BOSS1.getMediaPlayer().setOnEndOfMedia(() -> Musics.BOSS1.getMediaPlayer().stop());
    }

    public void boss2() {
        Musics.BOSS2.getMediaPlayer().play();
        Musics.BOSS2.getMediaPlayer().setOnEndOfMedia(() -> Musics.BOSS2.getMediaPlayer().stop());
    }

}
