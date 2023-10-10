package ru.ollyeys.springcourse;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

public class JazzMusic implements Music {

    private List<String> listJazzSongs = new ArrayList<>();

    // instance initialization block
    {
        listJazzSongs.add("Take five");
        listJazzSongs.add("Summertime");
        listJazzSongs.add("Fly Me to the Moom");
    }

    @Override
    public List<String> getSong() {
        return listJazzSongs;
    }

}
