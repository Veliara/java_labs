package com.company;

public class Main {

    Student[] students;
    Teacher[] teachers;

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    void run() {
        int n = 1, m =1;
        students = new Student[n];
        teachers = new Teacher[m];

        //students[0] = new Student(1, "dfgh", "fv", "fg", "04.04.2004", "dfgh", "5432", ";66kmjnhbg", 1, "4321");
        //students[1] = new Student(2, "llk", "hghjk", "sdfg", "01.01.2001", "tyui", "7654", ";34nf", 3, "876");
        //teachers[0] = new Teacher(101, "Фам", "Им", "Отч", "11.11.1111", "адрес 33б ", "2345", "ОС", "Доцент");
        //teachers[1] = new Teacher(102, "Фамилия", "Имя", "Отчес", "22.10.1212", "адрес 4313 ", "7654", "ООП", "Проф");

        inputStuds();
        outputAll(students);

        inputTeachers();
        outputAll(teachers);
    }

    public void outputAll(Human[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }
    }

    public void inputStuds() {
        for (int i = 0; i < students.length; i++) {
            students[i] = Input.inputStudent();
            System.out.println();
        }
    }

    public void inputTeachers() {
        for (int i = 0; i < teachers.length; i++) {
            teachers[i] = Input.inputTeacher();
            System.out.println();
        }
    }

}
