package ru.ollyeys.springcourse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.*;

import java.util.ArrayList;
import java.util.List;


public class ClassicalMusic implements Music {

    private List<String> listClassicalSongs = new ArrayList<>();
    // instance initialization block
    {
        listClassicalSongs.add("Hungarian Rhapsody");
        listClassicalSongs.add("Elise");
        listClassicalSongs.add("Evgeny Onegin");
    }

    @Override
    public List<String> getSong() {
        return listClassicalSongs;
    }


}
