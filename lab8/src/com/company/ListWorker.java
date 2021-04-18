package com.company;

import java.util.Comparator;
import java.util.List;
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

    public List<Customer> searchName(List<Customer> list, String name) {
        return list.stream().filter(customer -> customer.getFullName().equals(name))
                .collect(Collectors.toList());

    }

    public List<Customer> searchCredCard(List<Customer> list, long start, long end) {
        return list.stream().filter(customer -> customer.getCreditCardNum() >= start
                && customer.getCreditCardNum() <= end)
                .collect(Collectors.toList());
    }

    public List<Customer> searchDebt(List<Customer> list) {
        //Comparator<Customer> comparator = Comparator.comparingDouble(c -> -c.getBalance());
        return list.stream().filter(customer -> customer.getBalance() < 0)
                .sorted(Comparator.comparing(Customer::getBalance, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    public List<Customer> listSort(List<Customer> list) {
        list.sort(Comparator.comparingDouble(Customer::getBalance)
                .thenComparing(Customer::getCreditCardNum));
        return list;
    }

}
