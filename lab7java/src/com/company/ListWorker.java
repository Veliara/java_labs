package com.company;

import java.time.LocalDate;
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

    public ArrayList<Customer> searchName(List<Customer> list, String name) {
        ArrayList<Customer> searchRes = new ArrayList<>();
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

    public ArrayList<Customer> searchCredCard(List<Customer> list, long start, long end) {
        ArrayList<Customer> searchRes = new ArrayList<>();
        for (Customer customer : list) {
            long temp = customer.getCreditCardNum();
            if (temp >= start && temp <= end) {
                searchRes.add(customer);
            }
        }
        return searchRes;
    }

    public ArrayList<Customer> searchDebt(List<Customer> list) {
        ArrayList<Customer> debtors = new ArrayList<>();

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

    public Set<LocalDate> setDates(List<Customer> list) {
        Set<LocalDate> allDate = new HashSet<>();
        for (Customer customer : list) {
            allDate.add(customer.getBirthday());
        }
        return allDate;
    }

    public Map<Integer, Customer> richByYear(List<Customer> list) {
        Map<Integer, Customer> rich = new HashMap<>();
        for (Customer customer : list) {
            Integer year = customer.getBirthday().getYear();
            Customer custV = rich.get(year);
            if (custV == null) custV = customer;
            else if (custV.getBalance() < customer.getBalance())
                custV = customer;
            rich.put(year, custV);
        }
        return rich;
    }
}
