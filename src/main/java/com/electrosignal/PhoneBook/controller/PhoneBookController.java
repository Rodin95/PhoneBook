package com.electrosignal.PhoneBook.controller;

import com.electrosignal.PhoneBook.domain.Person;
import com.electrosignal.PhoneBook.domain.User;
import com.electrosignal.PhoneBook.repos.PhoneBookRepo;
import com.electrosignal.PhoneBook.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class PhoneBookController {
    @Autowired
    private PhoneBookRepo phoneBookRepo;

    @Autowired
    private PersonService personService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/phoneBook")
    public String main(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 50, sort = {"department"}, direction = Sort.Direction.ASC) Pageable pageable // сортировка списка по id для того чтобы поменять нужно изменить этот параметр {"id"} и
            // в ппервую очередь показываются сообщения которые были созданы последние командой Sort.Direction.DESC если нужно изменить сортировку нужно изменить этот парметр
    ) {
        Page<Person> page = personService.personList(pageable, filter);

        if (!StringUtils.isEmpty(filter)) {
            model.addAttribute("url", String.format("/phoneBook?filter=%s", filter));
        } else {
            model.addAttribute("url", "/phoneBook");
        }

        model.addAttribute("page", page);
        model.addAttribute("filter", filter);

        return "phoneBook";
    }


    @PostMapping("/phoneBook")
    public String add(
            @AuthenticationPrincipal User user,
            @Valid Person person,
            BindingResult bindingResult,
            Model model,
            @PageableDefault(size = 50, sort = {"department"}, direction = Sort.Direction.ASC) Pageable pageable,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        person.setAuthor(user);

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("person", person);

        } else {

            saveFile(person, file);
            model.addAttribute("person", null);
            phoneBookRepo.save(person);

        }

        model.addAttribute("url", "/phoneBook");
        Page<Person> page = this.personService.personList(pageable, "");
        model.addAttribute("page", page);

        return "phoneBook";
    }

    public void saveFile(@Valid Person person, @RequestParam("file") MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            person.setFilename(resultFilename);
        }
    }

    @GetMapping("/user-persons/{author}")
    public String userPersons(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User author,
            Model model,
            @RequestParam(required = false) Person person,
            @PageableDefault(sort = {"department"}, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        Page<Person> page = personService.personListForUser(pageable, currentUser, author);

        model.addAttribute("page", page);
        model.addAttribute("person", person);
        model.addAttribute("isCurrentUser", currentUser.equals(author));
        return "userPersons";
    }

    @PostMapping("/user-persons/{user}")
    public String updatePerson(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            @RequestParam("id") Person person,
            @RequestParam("firstName") String firstName,
            @RequestParam("secondName") String secondName,
            @RequestParam("thirdName") String thirdName,
            @RequestParam("department") String department,
            @RequestParam("position") String position,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("location") String location,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        if (person.getAuthor().equals(currentUser)) {
            if (!StringUtils.isEmpty(firstName)) {
                person.setFirstName(firstName);
            }
            if (!StringUtils.isEmpty(secondName)) {
                person.setSecondName(secondName);
            }
            if (!StringUtils.isEmpty(thirdName)) {
                person.setThirdName(thirdName);
            }
            if (!StringUtils.isEmpty(department)) {
                person.setDepartment(department);
            }
            if (!StringUtils.isEmpty(phoneNumber)) {
                person.setPhoneNumber(phoneNumber);
            }
            if (!StringUtils.isEmpty(position)) {
                person.setPosition(position);
            }
            if (!StringUtils.isEmpty(location)) {
                person.setLocation(location);
            }

            saveFile(person, file);

            phoneBookRepo.save(person);
        }
        return "redirect:/phoneBook";
    }

    @GetMapping("/del-user-persons/{user}")
    public String deletePerson(
            @RequestParam("person") Long personId,
            @PathVariable String user) {

        phoneBookRepo.deleteById(personId);

        return "redirect:/phoneBook";
    }

}
