package com.company;

import java.util.Scanner;

public class Main {

    Student[] students;

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    void run() {
        students = new Student[20];
        insertStudents();

        boolean proceed = true;
        while (proceed) {
            System.out.println("Выберите действие");
            System.out.println("Поиск по:\n    1 -> факультету;\n    2 -> году рождения;\n    3 -> группе;");
            System.out.println("4 -> вывести всех;\n5 -> выход.");
            System.out.print("Ваш выбор: ");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            switch (num) {
                case 1 -> {
                    searchFacultyRequest();
                    proceed = retention();
                }
                case 2 -> {
                    searchYearRequest();
                    proceed = retention();
                }
                case 3 -> {
                    searchGroupRequest();
                    proceed = retention();
                }
                case 4 -> {
                    System.out.println();
                    allOutput();
                }
                case 5 -> {
                    proceed = false;
                    System.out.print("До свидания!");
                }
                default -> System.out.println("Введите правильно");
            }
            System.out.println();
        }
    }

    void insertStudents() {
        String[] names = {
                "Воробьёва Мила Всеволодовна",
                "Блинова Женевьева Феликсовна",
                "Фёдорова Нелли Кимовна",
                "Королёва Стефания Валентиновна",
                "Исаков Афанасий Тихонович",
                "Суханова Доминика Мартыновна",
                "Прохорова Вероника Семёновна",
                "Белов Юстиниан Львович",
                "Субботина Раиса Юлиановна",
                "Богданов Ипполит Даниилович",
                "Громова Иветта Улебовна",
                "Степанова Альжбета Вадимовна",
                "Лыткин Юрий Аркадьевич",
                "Ширяев Клемент Леонидович",
                "Абрамов Гарри Созонович",
                "Назаров Орест Куприянович",
                "Ершов Любомир Еремеевич",
                "Кузнецов Вольдемар Георгиевич",
                "Дроздова Таира Станиславовна",
                "Марков Георгий Ростиславович"
        };
        String[] dates = {
                "23.01.1997",
                "07.01.2000",
                "30.07.1999",
                "27.07.2000",
                "24.12.2001",
                "26.03.1997",
                "15.07.1998",
                "11.11.2000",
                "25.10.1999",
                "28.01.1998",
                "25.02.1999",
                "12.08.1998",
                "28.01.1999",
                "20.08.1998",
                "26.05.1998",
                "12.05.1999",
                "08.02.1997",
                "21.05.2000",
                "13.11.1998",
                "03.10.1998"
        };

        for (int i = 0; i < 20; i++ ) {
            String[] name = names[i].split(" ");
            students[i] = new Student(i, name[0], name[1], name[2], dates[i]);
        }
    }

    public void allOutput() {
        System.out.print("Все студенты:\n");
        for (Student student : students)
            System.out.println(student.toString());
    }

    public void searchFaculty(String faculty) {
        for (Student student : students)
            if (student.getFaculty().equals(faculty))
                System.out.println(student.toString());
    }

    public void searchYear(int year) {
        for (Student student : students)
            if (student.getBirthYear() == year)
                System.out.println(student.toString());
    }

    public void searchGroup(String group) {
        for (Student student : students)
            if (student.getGroup().equals(group))
                System.out.println(student.toString());
    }

    public void searchFacultyRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Существующие факультеты: Инженерия програмного обеспечения, Учебно-научный институт автоматики и электротехники, Кафедра морського приладобудування");
        System.out.print("Поиск по факультету. Введите факультет: ");
        String faculty = scanner.nextLine();
        System.out.println("\nПодходящие студенты:");
        searchFaculty(faculty);
    }

    public void searchYearRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Поиск по году рождения. Введите год: ");
        int year = scanner.nextInt();
        System.out.printf("\nСтуденты, родившиеся в %d год:\n", year);
        searchYear(year);
    }

    public void searchGroupRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Существующие группы: 1157ст, 1142, 2147");
        System.out.print("Поиск по группе. Введите группу: ");
        String group = scanner.nextLine();
        System.out.printf("\nСтуденты группы %s:\n", group);
        searchGroup(group);
    }

    public boolean retention() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Нажмите любую клавишу для продолжения или наберите 'вых' для выхода");
        boolean proc;
        proc = !sc.nextLine().equals("вых");
        return proc;
    }

}
