package com.electrosignal.PhoneBook.controllers;

import com.electrosignal.PhoneBook.model.User;
import com.electrosignal.PhoneBook.service.UserService;
import com.electrosignal.PhoneBook.utils.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model) {

        if (user.getPassword() != null) {
            model.addAttribute("passwordError", "Поле пароль не может быть пустым!");
        }

        if(bindingResult.hasErrors()) {
           Map<String, String> errors =  ControllerUtils.getErrors(bindingResult);

           model.mergeAttributes(errors);

           return "registration";
        }

        if (!userService.addUser(user)) {
            model.addAttribute("usernameError", "Пользователь существует!");
            return "registration";
        }

        return "redirect:/login";
    }
}
