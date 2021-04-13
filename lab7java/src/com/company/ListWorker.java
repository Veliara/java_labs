package com.company;

import java.util.*;

public class ListWorker {

    public void printAll(List<Customer> list) {
        if(list.isEmpty()) System.out.println("Список пуст");
        else {
            for (Customer elem : list) {
                System.out.println(elem);
            }
        }
        System.out.println();
    }

    public List<Customer> searchName(List<Customer> list, String name) {
        List<Customer> searchRes = new ArrayList<>();
        String[] fullName = name.split(" ");

        for (Customer customer : list) {
            if (customer.getSurname().equals(fullName[0]) &&
                    customer.getName().equals(fullName[1]) &&
                    customer.getPatronymic().equals(fullName[2])
            ) {
                searchRes.add(customer);
            }
        }
        return searchRes;
    }

    public List<Customer> searchCredCard(List<Customer> list, long start, long end) {
        List<Customer> searchRes = new ArrayList<>();
        for (Customer customer : list) {
            long temp = customer.getCreditCardNum();
            if (temp >= start && temp <= end) {
                searchRes.add(customer);
            }
        }
        return searchRes;
    }

    public List<Customer> searchDebt(List<Customer> list) {
        List<Customer> debtors = new ArrayList<>();

        for (Customer customer : list) {
            if (customer.getBalance() < 0) debtors.add(customer);
        }
        debtors.sort(Comparator.comparingDouble(Customer::getBalance));
        Collections.reverse(debtors);

        return debtors;
    }

    public List<Customer> listSort(List<Customer> list) {
        list.sort(Comparator.comparingDouble(Customer::getBalance).
                thenComparing(Customer::getCreditCardNum));
        return list;
    }

}
