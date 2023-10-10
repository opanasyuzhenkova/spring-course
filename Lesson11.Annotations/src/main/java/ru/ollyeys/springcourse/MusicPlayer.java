package ru.ollyeys.springcourse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer {
    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }

    public void  playMusic(MusicGenre genre) {
        Random random = new Random();
        int randomOption = random.nextInt(3);
        if (genre == MusicGenre.ROCK) {
            System.out.println(rockMusic.getSongs().get(randomOption));
        } else {
            System.out.println(classicalMusic.getSongs().get(randomOption));
        }
    }
}
