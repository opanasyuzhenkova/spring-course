package ru.ollyeys.springcourse;

import java.util.ArrayList;
import java.util.List;


public class PopMusic implements Music {
    private List<String> listPopSongs = new ArrayList<>();
    @Override
    public List<String> getSongs() {

        return listPopSongs;
    }
}
