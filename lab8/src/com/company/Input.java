package com.company;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Input {

    public static Customer inputCustomer() {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
        boolean correct;

        //id
        do {
            try {
                System.out.println("Введите id");
                customer.setId(Integer.parseInt(scanner.nextLine()));
                correct = true;
            } catch (NumberFormatException e) {
                correct = false;
                System.out.println("!!!Пожалуйста, введите правильный id");
            }
        } while (!correct);

        System.out.println("Введите фамилию");
        customer.setSurname(scanner.nextLine());
        System.out.println("Введите имя");
        customer.setName(scanner.nextLine());
        System.out.println("Введите отчество");
        customer.setPatronymic(scanner.nextLine());

        //день рождения
        do {
            try {
                System.out.println("Введите день рождения в формате дд.мм.гггг");
                customer.setBirthday(customer.toDate(scanner.nextLine()));
                correct = true;
            } catch (DateTimeParseException e) {
                correct = false;
                System.out.println("!!!Пожалуйста, введите в формате дд.мм.гггг");
            }
        } while (!correct);

        System.out.println("Введите адрес");
        customer.setAddress(scanner.nextLine());

        System.out.println("Введите номер кредитной карты");
        customer.setCreditCardNum(Long.parseLong(scanner.nextLine()));

        System.out.println("Введите баланс");
        customer.setBalance(Double.parseDouble(scanner.nextLine()));

        return customer;
    }

}
