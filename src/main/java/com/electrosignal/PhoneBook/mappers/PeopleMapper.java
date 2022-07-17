package com.electrosignal.PhoneBook.mappers;

import com.electrosignal.PhoneBook.dto.PeopleDTO;
import com.electrosignal.PhoneBook.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeopleMapper {

    PeopleMapper INSTANCE = Mappers.getMapper(PeopleMapper.class);

    List<Person> toDTO(List<Person> person);
}
