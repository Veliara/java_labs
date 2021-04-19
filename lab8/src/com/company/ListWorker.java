package com.company;

import java.time.LocalDate;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class ListWorker {

    public void printAll(List<Customer> list) {
        try {
            list.forEach(System.out::println);
            System.out.println();
        } catch (NullPointerException e) {
            System.out.println("Список пуст");
        }
    }

    // список покупців, упорядкований за зростанням балансу рахунку, а при
    //рівності балансів – за номером кредитної картки
    public List<Customer> listSortBalance(List<Customer> list) {
        list.sort(Comparator.comparingDouble(Customer::getBalance)
                .thenComparing(Customer::getCreditCardNum));
        return list;
    }

    //список покупців, із вказаним іменем
    public List<Customer> searchName(List<Customer> list, String name) {
        return list.stream().filter(customer -> customer.getFullName().equals(name))
                .collect(Collectors.toList());
    }

    //список покупців, у яких номер кредитної картки знаходиться в заданому інтервалі
    public List<Customer> searchCredCard(List<Customer> list, long start, long end) {
        return list.stream().filter(customer -> customer.getCreditCardNum() >= start
                && customer.getCreditCardNum() <= end)
                .collect(Collectors.toList());
    }

    // кількість та список покупців, які мають заборгованість (від’ємний баланс на карті)
    // в порядку зростання заборгованості
    public List<Customer> searchDebt(List<Customer> list) {
        //Comparator<Customer> comparator = Comparator.comparingDouble(c -> -c.getBalance());
        return list.stream().filter(customer -> customer.getBalance() < 0)
                .sorted(Comparator.comparing(Customer::getBalance, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    //список років народження покупців, зареєстрованих у програмі без повторів
    public Set<LocalDate> setDates(List<Customer> list) {
        return list.stream()
                .map(Customer::getBirthday)
                .collect(Collectors.toSet());
    }

    //для кожного року народження визначити покупця, що має найбільшу кількість грошей на картці
    public Map<Integer, Customer> richByYear(List<Customer> list) {
        Comparator<Customer> bal = Comparator.comparingDouble(Customer::getBalance);
        return list.stream()
                .collect(Collectors.groupingBy(Customer::getYear,
                        Collectors.reducing(null,
                                BinaryOperator.maxBy(Comparator.nullsFirst(bal)))));
    }
}
