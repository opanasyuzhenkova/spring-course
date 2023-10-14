package ru.ollyeys.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ollyeys.springcourse.dao.PersonDAO;
import ru.ollyeys.springcourse.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    public String index(Model model) { // получение всех людей из DAO во view
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) { // получение одного человека по id из DAO
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")  // получаем html-форму для создания нового чела
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") Person person) { //объект Person() добавляем в бд
        personDAO.save(person);
        return "redirect:/people"; //редирект при добавлении нового человека в БД

    }
}
