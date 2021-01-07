package com.company;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Input {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static Student inputStudent() {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        boolean correct;

        //id
        do {
            try {
                System.out.println("Введите id студента");
                student.setId(Integer.parseInt(scanner.nextLine()));
                correct = true;
            } catch (NumberFormatException e) {
                correct = false;
                System.out.println(ANSI_RED+"!!!Пожалуйста, введите правильный id"+ANSI_RESET);
            }
        } while (!correct);

        System.out.println("Введите фамилию студента");
        student.setSurname(scanner.nextLine());
        System.out.println("Введите имя студента");
        student.setName(scanner.nextLine());
        System.out.println("Введите отчество студента");
        student.setPatronymic(scanner.nextLine());

        //день рождения
        do {
            try {
                System.out.println("Введите день рождения студента в формате дд.мм.гггг");
                student.setBirthday(scanner.nextLine());
                correct = true;
            } catch (DateTimeParseException e) {
                correct = false;
                System.out.println(ANSI_RED+"!!!Пожалуйста, введите в формате дд.мм.гггг"+ANSI_RESET);
            }
        } while (!correct);

        System.out.println("Введите адрес студента");
        student.setAddress(scanner.nextLine());
        System.out.println("Введите телефон студента");
        student.setPhone(scanner.nextLine());
        System.out.println("Введите факультет");
        student.setFaculty(scanner.nextLine());
        //курс
        do {
            try {
                System.out.println("Введите курс");
                student.setCourse(Integer.parseInt(scanner.nextLine()));
                correct = true;
            } catch (NumberFormatException e) {
                correct = false;
                System.out.println(ANSI_RED+"!!!Пожалуйста, введите правильный курс"+ANSI_RESET);
            }
        } while (!correct);

        System.out.println("Введите группу");
        student.setGroup(scanner.nextLine());
        return student;
    }


    public static Teacher inputTeacher() {
        Scanner scanner = new Scanner(System.in);
        Teacher teacher = new Teacher();
        boolean correct;

        //id
        do {
            try {
                System.out.println("Введите id преподавателя");
                teacher.setId(Integer.parseInt(scanner.nextLine()));
                correct = true;
            } catch (NumberFormatException e) {
                correct = false;
                System.out.println(ANSI_RED+"!!!Пожалуйста, введите правильный id"+ANSI_RESET);
            }
        } while (!correct);

        System.out.println("Введите фамилию преподавателя");
        teacher.setSurname(scanner.nextLine());
        System.out.println("Введите имя преподавателя");
        teacher.setName(scanner.nextLine());
        System.out.println("Введите отчество преподавателя");
        teacher.setPatronymic(scanner.nextLine());

        //день рождения
        do {
            try {
                System.out.println("Введите день рождения преподавателя в формате дд.мм.гггг");
                teacher.setBirthday(scanner.nextLine());
                correct = true;
            } catch (DateTimeParseException e) {
                correct = false;
                System.out.println(ANSI_RED+"!!!Пожалуйста, введите в формате дд.мм.гггг"+ANSI_RESET);
            }
        } while (!correct);

        System.out.println("Введите адрес преподавателя");
        teacher.setAddress(scanner.nextLine());
        System.out.println("Введите телефон преподавателя");
        teacher.setPhone(scanner.nextLine());
        System.out.println("Введите предмет");
        teacher.setSubject(scanner.nextLine());
        System.out.println("Введите должность");
        teacher.setPosition(scanner.nextLine());

        return teacher;
    }

}

