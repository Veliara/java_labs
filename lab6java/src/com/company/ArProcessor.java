package com.company;

public class ArProcessor implements ArrayProcessor{
    @Override
    public double calculate(double[] array) {
        //Найти произведение элементов массива
        double mult = 1;
        for (double v : array) {
            mult *= v;
        }
        return mult;
    }

    @Override
    public double calculate(double[][] array) {
        //Найти наибольший элем под побочной диагональю
        double max = array[0][array[0].length-1];
        for (int i = 1; i < array.length; i++) {
            for (int j = array.length-i-1; j < array.length; j++) {
                if (array[i][j] > max) max = array[i][j];
            }
        }
        return max;
    }

    @Override
    public void processArray(double[] array) {
        for (double v : array) {
            System.out.print(" " + v+" ");
        }
        System.out.println();
    }

    @Override
    public void processArray(double[][] array) {
        for (double[] doubles : array) {
            for (double aDouble : doubles) {
                System.out.print(" " + aDouble + " ");
            }
            System.out.println();
        }
    }
}
