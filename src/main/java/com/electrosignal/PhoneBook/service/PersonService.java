package com.electrosignal.PhoneBook.service;

import com.electrosignal.PhoneBook.domain.Person;
import com.electrosignal.PhoneBook.domain.User;
import com.electrosignal.PhoneBook.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;

    public Page<Person> personList(Pageable pageable, String filter) {
        if (filter != null && !filter.isEmpty()) {
            return personRepo.findByFirstNameContainingIgnoreCaseOrSecondNameContainingIgnoreCaseOrThirdNameContainingIgnoreCaseOrDepartmentContainingIgnoreCaseOrPositionContainingIgnoreCaseOrPhoneNumberContainingIgnoreCaseOrLocationContainingIgnoreCase(filter, filter, filter, filter, filter, filter, filter, pageable);
        } else {
            return personRepo.findAll(pageable);
        }
    }

    public Page<Person> personListForUser(Pageable pageable, User currentUser, User author) {
        return personRepo.findByUser(pageable, author);
    }
}
