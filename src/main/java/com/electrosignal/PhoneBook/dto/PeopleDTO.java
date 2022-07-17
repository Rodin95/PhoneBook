package com.electrosignal.PhoneBook.dto;

import com.electrosignal.PhoneBook.model.Person;
import com.electrosignal.PhoneBook.model.User;
import com.electrosignal.PhoneBook.model.util.PeopleHelper;

import java.util.Objects;

public class PeopleDTO {

    private String firstName;
    private String secondName;
    private String thirdName;
    private String phoneNumber;
    private String department;
    private String position;
    private String location;


    public PeopleDTO(Person person) {
        this.secondName = person.getSecondName();
        this.thirdName = person.getThirdName();
        this.phoneNumber = person.getPhoneNumber();
        this.department = person.getDepartment();
        this.position = person.getPosition();
        this.location = person.getLocation();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

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
