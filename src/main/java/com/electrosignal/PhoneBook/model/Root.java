package com.electrosignal.PhoneBook.model;

import java.util.List;

public class Root {

private List<Person> people;

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Root{" +
                "people=" + people +
                '}';
    }
}
