package com.electrosignal.PhoneBook.controllers;

import com.electrosignal.PhoneBook.model.Root;
import com.electrosignal.PhoneBook.service.ParserJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class JsonParserController {

    private final ParserJsonService parserJsonService;

    @Autowired
    public JsonParserController(ParserJsonService parserJsonService) {
        this.parserJsonService = parserJsonService;
    }

    public Root parse() {

        return parserJsonService.parseFromFile(null);
    }

}
