package com.electrosignal.PhoneBook.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Пожалуйста заполните поле!")
    @Length(max = 255, message = "Слишком длинное имя (более чем 255 байта)")
    private String firstName;

    @NotBlank(message = "Пожалуйста заполните поле!")
    @Length(max = 255, message = "Слишком длинное имя (более чем 255 байта)")
    private String secondName;

    @NotBlank(message = "Пожалуйста заполните поле!")
    @Length(max = 255, message = "Слишком длинное имя (более чем 255 байта)")
    private String thirdName;

    @Pattern(regexp = "\\d{2}-\\d{2}", message = "Пожалуйста следуйте правилу: XX-XX")
    private String phoneNumber;

    @NotBlank(message = "Пожалуйста заполните поле!")
    @Length(max = 255, message = "Слишком длинное имя (более чем 255 байта)")
    private String department;

    @NotBlank(message = "Пожалуйста заполните поле!")
    @Length(max = 255, message = "Слишком длинное имя (более чем 255 байта)")
    private String position;

    @NotBlank(message = "Пожалуйста заполните поле!")
    @Length(max = 255, message = "Слишком длинное имя (более чем 255 байта)")
    private String location;

    private String filename;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

   public Person() {}

    public Person(String firstName, String secondName, String thirdName, String department, String position, String phoneNumber, String location, User user) {

        this.author = user;
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.position = position;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAuthorName() {
       return author != null ? author.getUsername() : "Unknown";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
