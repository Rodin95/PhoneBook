package com.electrosignal.PhoneBook.repos;

import com.electrosignal.PhoneBook.domain.Person;
import com.electrosignal.PhoneBook.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepo extends CrudRepository<Person, Long> {

    Page<Person> findAll(Pageable pageable);
    Page<Person> findByFirstNameContainingIgnoreCaseOrSecondNameContainingIgnoreCaseOrThirdNameContainingIgnoreCaseOrDepartmentContainingIgnoreCaseOrPositionContainingIgnoreCaseOrPhoneNumberContainingIgnoreCaseOrLocationContainingIgnoreCase(String firstName, String secondName, String thirdName, String department, String position, String phoneNumber, String location, Pageable pageable);

    @Query("from  Person p where p.author = :author")
    Page<Person> findByUser(Pageable pageable, @Param("author") User author);
}
