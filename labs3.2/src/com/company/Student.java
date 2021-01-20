package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate birthday;
    private String address;
    private String phone;
    private String faculty;
    private int course;
    private String group;

    Student() {

    }

    /*Student(int id, String surname, String name, String patronymic, String birthday, String address, String phone, String faculty, int course, String group) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        //this.birthday = new LocalDate();
        setBirthday(birthday);
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }*/

    Student(int id, String surname, String name, String patronymic, String birthday) {
        setId(id);
        setSurname(surname);
        setName(name);
        setPatronymic(patronymic);
        setBirthday(birthday);
        setAddress("Какой-то адрес");
        setPhone("0" + (int)(100000000 + Math.random() * 899999999));

        String[] faculties = {"Инженерия програмного обеспечения", "Учебно-научный институт автоматики и электротехники", "Кафедра морського приладобудування"};
        String[] groups = {"1157ст", "1142", "2147"};

        setFaculty(faculties[(int)(Math.random()*3)]);
        setCourse((int)(1+Math.random()*5));
        setGroup(groups[(int)(Math.random()*3)]);
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

    public int getBirthYear() {
        return birthday.getYear();
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

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "" + getId() + ": " + getSurname() + " " + getName() + " " + getPatronymic() + ", " + getBirthday() + ", " + getAddress() + ", " + getPhone() + ", " + getFaculty() + ", " + getCourse() + " курс, группа " + getGroup();
    }
}
