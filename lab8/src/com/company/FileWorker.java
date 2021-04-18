package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.*;

public class FileWorker {

    public List<Customer> readFile(Path path) {
        try (Stream<String> lineStream = Files.newBufferedReader(path).lines()) {

            List<Customer> list = new ArrayList<>();
            Customer temp = new Customer();

            List<String> lines = lineStream.collect(Collectors.toList());

            for (String line : lines) {
                if (!line.isEmpty()) list.add(temp.toCustomer(line));
            }
            return list;
        } catch (IOException ex) {
            System.err.println("Error reading file");
            return null;
        }
    }

    public void writeFile(Path path, Customer customer) {
        try (BufferedWriter writer = Files.newBufferedWriter(path, WRITE, APPEND, CREATE)){
            writer.write(customer.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing file");
        }
    }

    public void writeFile(Path path, List<Customer> list) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)){
            for (Customer customer : list) {
                writer.write(customer.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing file");
        }
    }
}
