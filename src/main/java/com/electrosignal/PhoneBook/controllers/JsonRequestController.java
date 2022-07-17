package com.electrosignal.PhoneBook.controllers;

import com.electrosignal.PhoneBook.model.User;
import com.electrosignal.PhoneBook.service.JsonRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonRequestController {

    private final JsonRequestService jsonRequestService;

    @Autowired
    public JsonRequestController(JsonRequestService jsonRequestService) {
        this.jsonRequestService = jsonRequestService;
    }

    @RequestMapping("json")
    public void json(@AuthenticationPrincipal User user) {
        jsonRequestService.jsonRequest(user);
    }
}