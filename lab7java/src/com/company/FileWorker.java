package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardOpenOption.*;

public class FileWorker {

    public List<Customer> readFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path))
        {
            List<Customer> list = new ArrayList<>();
            Customer temp = new Customer();

            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {
                if (!line.isEmpty()) list.add(temp.toCustomer(line));
            }

            return list;
        }
        catch (IOException ex)
        {
            System.err.println("Error reading file");
            return null;
        }
    }

    public void writeFile(Path path, Customer customer) {
        try (BufferedWriter writer = Files.newBufferedWriter(path, WRITE, APPEND, CREATE)){
            writer.write(customer.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//List<String> lines = Files.readAllLines(path);
