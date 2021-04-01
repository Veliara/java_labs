package com.company;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.run();
    }

    private void run(){
        ArProcessor processor = new ArProcessor();
        ArrayReader reader = new ArrayReader();

        File file = new File("file1.2.txt");
        double[] arr1 = reader.readOneDimensionalArray(file);
        processor.processArray(arr1);
        System.out.println("Произведение всех элем = "+ processor.calculate(arr1)+"\n");

        double[][] arr2 = reader.readTwoDimensionalArray("file2.2.txt");
        processor.processArray(arr2);
        System.out.println("Max = "+ processor.calculate(arr2));

    }
}
