package ru.ollyeys.springcourse.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) { // объект Person() добавляем в бд
        if (bindingResult.hasErrors())
            return "people/new";
        personDAO.save(person);
        return "redirect:/people"; //редирект при добавлении нового человека в БД

    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "people/edit";
        personDAO.update(id, person);
        return "redirect:/people";

    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }
}
