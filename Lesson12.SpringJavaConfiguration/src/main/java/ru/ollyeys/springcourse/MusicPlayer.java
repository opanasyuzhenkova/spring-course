package ru.ollyeys.springcourse;


import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Random;

public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    private List<Music> musicGenres;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }


    public MusicPlayer(List<Music> musicGenres) {
        this.musicGenres = musicGenres;
    }

    public String playMusic() {
        Random random = new Random();
        return "Playing: " + musicGenres.get(random.nextInt(musicGenres.size())).getSong().get(random.nextInt(3)) + ". Volume = " + this.volume;

    }
}
