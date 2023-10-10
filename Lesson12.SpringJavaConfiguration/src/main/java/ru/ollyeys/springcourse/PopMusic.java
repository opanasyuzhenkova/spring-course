package ru.ollyeys.springcourse;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;


public class PopMusic implements Music {
    private List<String> listPopSongs = new ArrayList<>();

    // instance initialization block
    {
        listPopSongs.add("Shape of You");
        listPopSongs.add("Uptown Funk");
        listPopSongs.add("Blinding Lights");
    }

    @Override
    public List<String> getSong() {
        return listPopSongs;
    }
}
