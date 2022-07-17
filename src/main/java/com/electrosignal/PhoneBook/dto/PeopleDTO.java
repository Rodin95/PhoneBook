package com.electrosignal.PhoneBook.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class PeopleDTO {

    private String firstName;
    private String secondName;
    private String thirdName;
    private String phoneNumber;
    private String department;
    private String position;
    private String location;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeopleDTO peopleDto = (PeopleDTO) o;
        return firstName.equals(peopleDto.firstName) && secondName.equals(peopleDto.secondName) && thirdName.equals(peopleDto.thirdName) && position.equals(peopleDto.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, thirdName, position);
    }

    @Override
    public String toString() {
        return "PeopleDTO{" +

                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", thirdName='" + thirdName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

}
