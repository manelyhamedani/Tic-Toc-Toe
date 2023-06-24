package com.manely.ap.lab.tictactoe;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

public class MusicPlayer {
    private static final MediaPlayer mediaPlayer;

    static {
        String songPath = "song.mp3";
        Media media = new Media(Paths.get(songPath).toUri().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }

    private MusicPlayer() {
    }

    public static void play() {
        mediaPlayer.play();
    }

    public static void changeStatus() {
        if (mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED) {
            mediaPlayer.play();
        }
        else {
            mediaPlayer.pause();
        }
    }
}
