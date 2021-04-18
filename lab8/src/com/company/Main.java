package com.company;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

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
        //listWorker.printAll(customers);

        
        int menu;
        do {
            System.out.println("-".repeat(30));
            System.out.println("Введите номер пункта меню:");
            System.out.println("1 - вывести всех покупателей;");
            System.out.println("2 - прочитать из файла;");
            System.out.println("3 - записать нового покупателя в файл;");
            System.out.println("4 - удалить покупателя;");

            System.out.println("5 - поиск по имени;");
            System.out.println("6 - поиск по интервалу кредитной карты;");
            System.out.println("7 - вывести всех по балансу по возрастанию");
            System.out.println("8 - должники");
            System.out.println("9 - список всех дней рождения");
            System.out.println("10 - для каждого года рождения покупатель с наибольшим балансом");

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
                //удалить элемент
                case 4:
                    listWorker.printAll(customers);
                    System.out.print("Введите id покупателя на удаление: ");
                    int id = scanner.nextInt();
                    if(customers.removeIf(customer -> customer.getId() == id)) {
                        fileWorker.writeFile(path, customers);
                        System.out.println("Удаление успешно");
                    }
                    else System.out.println("Нет такого покупателя");
                    pause();
                    break;
                //список покупців, із вказаним іменем
                case 5:
                    System.out.println("Введите полное имя для поиска:");
                    Scanner sc = new Scanner(System.in);
                    String name = sc.nextLine();
                    List<Customer> searchName = listWorker.searchName(customers, name);
                    if (searchName.isEmpty()) System.out.println("Покупателей с таким именем нет");
                    else listWorker.printAll(searchName);
                    pause();
                    break;
                //список покупців, у яких номер кредитної картки знаходиться в заданому інтервалі
                case 6:
                    System.out.println("Интервал номеров кредитных карт");
                    long start, end;
                    start = inputInterval("Начало: ");
                    end = inputInterval("Конец: ");
                    List<Customer> searchCredCard = listWorker.searchCredCard(customers, start, end);
                    if (searchCredCard.isEmpty()) System.out.println("Карт в интервале нет");
                    else listWorker.printAll(searchCredCard);
                    pause();
                    break;
                // список покупців, упорядкований за зростанням балансу рахунку, а при
                //рівності балансів – за номером кредитної картки
                case 7:
                    listWorker.printAll(listWorker.listSort(customers));
                    pause();
                    break;
                // кількість та список покупців, які мають заборгованість (від’ємний баланс на
                //карті) в порядку зростання заборгованості
                case 8:
                    List<Customer> debt = listWorker.searchDebt(customers);
                    System.out.println("Количество должников: " + debt.size());
                    listWorker.printAll(debt);
                    pause();
                    break;
                //список років народження покупців, зареєстрованих у програмі без повторів
                case 9:
                    Set<LocalDate> dates = customers.stream()
                            .map(Customer::getBirthday)
                            .collect(Collectors.toSet());

                    System.out.println("Все зарегистрированные даты рождения без повторов:");
                    dates.stream().sorted().forEach(d -> System.out.print(d.format(DateTimeFormatter.ofPattern("d.M.y")) + ", "));
                    System.out.println();
                    pause();
                    break;
                //для кожного року народження визначити покупця, що має найбільшу кількість грошей на картці
                case 10:
                    Comparator<Customer> bal = Comparator.comparingDouble(Customer::getBalance);

                    Map<Integer, Customer> rich = customers.stream()
                            .collect(Collectors.groupingBy(Customer::getYear,
                                    Collectors.reducing(null,
                                            BinaryOperator.maxBy(Comparator.nullsFirst(bal)))));

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

     public long inputInterval(String s) {
         Scanner interval = new Scanner(System.in);
             try {
                 System.out.print(s);
                 return Long.parseLong(interval.nextLine());
             } catch (NumberFormatException e) {
                 System.out.println("!!!Пожалуйста, введите правильно");
                 return inputInterval(s);
             }
     }
}







