package com.company;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Path path = Paths.get("Customers.txt");
        Scanner scanner = new Scanner(System.in);
        FileWorker fileWorker = new FileWorker();
        ListWorker listWorker = new ListWorker();
        List<Customer> customers;

        customers = fileWorker.readFile(path);
        listWorker.printAll(customers);


        int menu;
        do {
            System.out.println("-".repeat(30));
            System.out.println("Введите номер пункта меню:");
            System.out.println("1 - вывести всех покупателей;");
            System.out.println("2 - прочитать из файла;");
            System.out.println("3 - записать нового покупателя в файл;");

            System.out.println("4 - поиск по имени;");
            System.out.println("5 - поиск по интервалу кредитной карты;");
            System.out.println("6 - должники");
            System.out.println("7 - вывести всех по балансу по возрастанию");
            System.out.println("0 - выход");
            System.out.print("!!Введите: ");

            menu = scanner.nextInt();

            switch (menu){
                //Вывести всех
                case 1:
                    listWorker.printAll(customers);
                    pause();
                    break;
                //из файла в лист
                case 2:
                    customers = fileWorker.readFile(path);
                    pause();
                    break;
                //новый элемент
                case 3:
                    Customer newCust = Input.inputCustomer();
                    customers.add(newCust);
                    fileWorker.writeFile(path, newCust);
                    pause();
                    break;
                //поиск по имени
                case 4:
                    System.out.println("Введите полное имя для поиска:");
                    Scanner sc = new Scanner(System.in);
                    String name = sc.nextLine();
                    List<Customer> searchName = listWorker.searchName(customers, name);
                    if (searchName.isEmpty()) System.out.println("Покупателей с таким именем нет");
                    else listWorker.printAll(searchName);
                    pause();
                    break;
                //поиск карты по интервалу
                case 5:
                    System.out.println("Интервал номеров кредитных карт");
                    Scanner interval = new Scanner(System.in);
                    boolean correct;
                    long start = 0, end = 0;
                    do {

                        try {
                            System.out.print("Начало: ");
                            start = Long.parseLong(interval.nextLine());
                            correct = true;
                        } catch (NumberFormatException e) {
                            correct = false;
                            System.out.println("!!!Пожалуйста, введите правильно");
                        }
                    } while (!correct);

                    do {
                        try {
                            System.out.print("Конец: ");
                            end = Long.parseLong(interval.nextLine());
                            correct = true;
                        } catch (NumberFormatException e) {
                            correct = false;
                            System.out.println("!!!Пожалуйста, введите правильно");
                        }
                    } while (!correct);

                    List<Customer> searchCredCard = listWorker.searchCredCard(customers, start, end);
                    if (searchCredCard.isEmpty()) System.out.println("Карт в интервале нет");
                    else listWorker.printAll(searchCredCard);
                    pause();
                    break;
                // кол-во и список должников
                case 6:
                    List<Customer> debt = listWorker.searchDebt(customers);
                    System.out.print("Количество должников: ");
                    System.out.println(debt.size());
                    listWorker.printAll(debt);
                    pause();
                    break;
                // сортировка баланса по возрастанию
                case 7:
                    listWorker.printAll(listWorker.listSort(customers));
                    pause();
                    break;
                //дни рождения без повторов
                case 8:
                    Set<LocalDate> allDate = new HashSet<>();
                    for (Customer customer : customers) {
                        allDate.add(customer.getBirthday());
                    }
                    System.out.println("Все зарегестрированные даты рождения без повторов:");
                    System.out.println(allDate);
                    pause();
                    break;
                //самый богатый по годам рождения
                case 9:
                    Map<Integer, Customer> rich = new HashMap<>();
                    for (Customer customer : customers) {
                        Integer year = customer.getBirthday().getYear();
                        Customer custV = rich.get(year);
                        if (custV == null) custV = customer;
                        else if (custV.getBalance() < customer.getBalance())
                            custV = customer;
                        rich.put(year, custV);
                    }

                    for (Map.Entry<Integer, Customer> entry : rich.entrySet()) {
                        System.out.println(entry.getKey() + " - " + entry.getValue().toString());
                    }
                    pause();
                    break;

                case 0:
                    System.out.println("Завершение работы");
                    break;
                default:
                    System.out.println("Введите верное значение");
            }
        } while (menu != 0);

    }

    public void pause() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Нажмите любую клавишу для продолжения ");
        scanner.next();
    }
}







