package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Customer {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate birthday;
    private String address;
    private long creditCardNum;
    private double balance;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.y");

    public Customer() {}
    public Customer(int id, String surname, String name, String patronymic, LocalDate birthday, String address, long creditCardNum, double balance) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.address = address;
        this.creditCardNum = creditCardNum;
        this.balance = balance;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(long creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "" + getId() + ": " + getSurname() + " " + getName() + " " + getPatronymic() + ", " + getBirthday().format(formatter) + ", "
                + getAddress() + "; " + getCreditCardNum() + ":  " + getBalance();
    }

    public Customer toCustomer(String s) {
        String pattern = "\\s+|,\\s*|:\\s*|;\\s*";
        String[] splitResult = s.split(pattern);

        return new Customer(Integer.parseInt(splitResult[0]), splitResult[1], splitResult[2], splitResult[3],
                toDate(splitResult[4]), splitResult[5], Long.parseLong(splitResult[6]), Double.parseDouble(splitResult[7]));
    }

    public LocalDate toDate(String s) {
        return LocalDate.parse(s, formatter);
    }
}
