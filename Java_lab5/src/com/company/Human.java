package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Human {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate birthday;
    private String address;
    private String phone;

    public Human() {}
    public Human(int id, String surname, String name, String patronymic, String birthday, String address, String phone) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        setBirthday(birthday);
        this.address = address;
        this.phone = phone;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthday() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return birthday.format(df);
    }
    public void setBirthday(String birthday) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.birthday = LocalDate.parse(birthday, dtf);
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
