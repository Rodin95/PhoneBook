package com.electrosignal.PhoneBook.service;

import com.electrosignal.PhoneBook.model.Person;
import com.electrosignal.PhoneBook.model.User;
import com.electrosignal.PhoneBook.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Page<Person> personList(Pageable pageable, String filter) {
        if (filter != null && !filter.isEmpty()) {
            return peopleRepository.findByFirstNameContainingIgnoreCaseOrSecondNameContainingIgnoreCaseOrThirdNameContainingIgnoreCaseOrDepartmentContainingIgnoreCaseOrPositionContainingIgnoreCaseOrPhoneNumberContainingIgnoreCaseOrLocationContainingIgnoreCase(filter, filter, filter, filter, filter, filter, filter, pageable);
        } else {
            return peopleRepository.findAll(pageable);
        }
    }

    public Page<Person> personListForUser(Pageable pageable, User currentUser, User author) {
        return peopleRepository.findByUser(pageable, author);
    }

    public List<Person> findAll(){
        return peopleRepository.findAll();
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

    public void deletePerson(
            @RequestParam("person") Long personId) {

        peopleRepository.deleteById(personId);
    }

    public void save(@RequestParam("id") Person person) {
        peopleRepository.save(person);
    }

}
