package ru.ollyeys.springcourse;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Music {
    List<String> getSongs();
}
