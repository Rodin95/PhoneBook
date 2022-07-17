package com.electrosignal.PhoneBook.controllers;

import com.electrosignal.PhoneBook.mappers.PeopleMapper;
import com.electrosignal.PhoneBook.model.Person;
import com.electrosignal.PhoneBook.service.PeopleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JsonResponseController {

    private final PeopleService peopleService;

    public JsonResponseController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public List<Person> getPerson(){
        return peopleService.findAll(); // Jackson конвертирует эти обьекты в JSON
    }

    @GetMapping("/people")
    public List<Person> getPeople(){
        List<Person> person = peopleService.findAll();
        return PeopleMapper.INSTANCE.toDTO(person); // Jackson конвертирует эти обьекты в JSON
    }
}
