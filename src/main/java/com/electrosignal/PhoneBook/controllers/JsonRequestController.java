package com.electrosignal.PhoneBook.controllers;

import com.electrosignal.PhoneBook.model.Person;
import com.electrosignal.PhoneBook.model.Root;
import com.electrosignal.PhoneBook.model.User;
import com.electrosignal.PhoneBook.repository.PeopleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
public class JsonRequestController {
    private final static Logger logger = LoggerFactory.getLogger(JsonRequestController.class);

    private final PeopleRepository peopleRepository;

    private final JsonParserController jsonParserController;
    private final JsonResponseController jsonResponseController;

    public JsonRequestController(PeopleRepository peopleRepository, JsonParserController jsonParserController, JsonResponseController jsonResponseController) {
        this.peopleRepository = peopleRepository;
        this.jsonParserController = jsonParserController;
        this.jsonResponseController = jsonResponseController;
    }


    // Логика выборки уникальных людей(по фамилии имени и отчеству) для добавления в базу данных
    @RequestMapping("json")
    public void json(@AuthenticationPrincipal User user) {

        Root personJson = jsonParserController.parseFromFile(null);
        // из json файла
        List<Person> personJsonList = personJson.getPeople();
        // из DB
        List<Person> personList = jsonResponseController.getPerson();
        Iterator<Person> personJsonIterator = personJsonList.iterator();
        try {
            while (personJsonIterator.hasNext()) {
                Person jsonPerson = personJsonIterator.next();
//                  выборка из json уникальных людей для DB (по ФИО)

                if (personList.contains(jsonPerson)) {
                    personJsonIterator.remove();
                } else {
                    if (!(personList.contains(jsonPerson))) {
                        personList.add(jsonPerson);
                    }
                }

                if (jsonPerson.getFilename() == null) {
                    jsonPerson.setFilename("0");
                }
                if (jsonPerson.getPhoneNumber() == null) {
                    jsonPerson.setPhoneNumber("00-00");
                }
                if (jsonPerson.getAuthor() == null) {
                    jsonPerson.setAuthor(user);
                }

            }

            peopleRepository.saveAll(personList);
            logger.info("All records saved in database.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}