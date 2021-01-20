package com.company;

import java.util.Scanner;

public class Main {
    StringWork sw;

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        System.out.print("Введите строку: ");
        sw = new StringWork(insertStr());
        System.out.println("\nРезультат:");
        System.out.println(sw.getNewStr());
        System.out.println(sw.getNewNumericStr());
    }

    public String insertStr() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
