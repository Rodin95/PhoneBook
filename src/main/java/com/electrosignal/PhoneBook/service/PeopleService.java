package com.electrosignal.PhoneBook.service;

import com.electrosignal.PhoneBook.model.Person;
import com.electrosignal.PhoneBook.model.User;
import com.electrosignal.PhoneBook.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;



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

}
