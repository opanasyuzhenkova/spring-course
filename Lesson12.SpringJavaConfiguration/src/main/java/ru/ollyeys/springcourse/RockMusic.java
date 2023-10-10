package ru.ollyeys.springcourse;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;


public class RockMusic implements Music {
    private List<String> listRockSongs = new ArrayList<>();

    // instance initialization block
    {
        listRockSongs.add("Bohemian Rhapsody");
        listRockSongs.add("Stairway to Heaven");
        listRockSongs.add("Hotel California");
    }

    @Override
    public List<String> getSong() {
        return listRockSongs;
    }
}
