package ru.ollyeys.springcourse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RockMusic implements Music {

    private List<String> listRockSongs = new ArrayList<>();

    // instance initialization block
    {
        listRockSongs.add("Wind cries Mary");
        listRockSongs.add("Stairway to Heaven");
        listRockSongs.add("Hotel California");
    }

    @Override
    public List<String> getSongs() {
        return listRockSongs;
    }
}
