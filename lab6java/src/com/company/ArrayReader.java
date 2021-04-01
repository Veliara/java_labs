package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ArrayReader implements DoubleArrayReader{
    @Override
    public double[] readOneDimensionalArray(File file) {
        try (Scanner reader = new Scanner(file)) {
            int n = reader.nextInt();
            double[] arr = new double[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = reader.nextDouble();
            }
            return arr;
        } catch (IOException ex) {
            System.err.println("Error reading file");
            return null;
        }
    }

    @Override
    public double[] readOneDimensionalArray(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            int n = Integer.parseInt(reader.readLine());
            double[] arr = new double[n];
            String[] sArr = reader.readLine().trim().split(" +");
            for (int i = 0; i < n; i++)
            {
                arr[i]=Double.parseDouble(sArr[i]);
            }
            return arr;
        }
        catch (IOException ex)
        {
            System.err.println("Error reading file");
            return null;
        }
    }

    @Override
    public double[][] readTwoDimensionalArray(File file) {
        try (Scanner reader = new Scanner(file)) {
            int n = reader.nextInt();
            double[][] arr = new double[n][n];
            for (int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr[i].length; j++)
                    arr[i][j] = reader.nextDouble();
            }
            return arr;
        } catch (IOException ex) {
            System.err.println("Error reading file");
            return null;
        }
    }

    @Override
    public double[][] readTwoDimensionalArray(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            int n = Integer.parseInt(reader.readLine());
            double[][] arr = new double[n][n];
            String[] sArr;
            for (int i = 0; i < n; i++) {
                sArr = reader.readLine().trim().split(" +");
                for(int j = 0; j < arr[i].length; j++)
                    arr[i][j] = Double.parseDouble(sArr[j]);
            }
            return arr;
        }
        catch (IOException ex)
        {
            System.err.println("Error reading file");
            return null;
        }
    }
}
