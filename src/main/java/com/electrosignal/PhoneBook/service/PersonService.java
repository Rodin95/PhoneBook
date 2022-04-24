package com.electrosignal.PhoneBook.service;

import com.electrosignal.PhoneBook.domain.Person;
import com.electrosignal.PhoneBook.domain.User;
import com.electrosignal.PhoneBook.repos.PhoneBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PhoneBookRepo phoneBookRepo;

    public Page<Person> personList(Pageable pageable, String filter) {
        if (filter != null && !filter.isEmpty()) {
            return phoneBookRepo.findByFirstNameContainingIgnoreCaseOrSecondNameContainingIgnoreCaseOrThirdNameContainingIgnoreCaseOrDepartmentContainingIgnoreCaseOrPositionContainingIgnoreCaseOrPhoneNumberContainingIgnoreCaseOrLocationContainingIgnoreCase(filter, filter, filter, filter, filter, filter, filter, pageable);
        } else {
            return phoneBookRepo.findAll(pageable);
        }
    }

    public Page<Person> personListForUser(Pageable pageable, User currentUser, User author) {
        return phoneBookRepo.findByUser(pageable, author);
    }
}
