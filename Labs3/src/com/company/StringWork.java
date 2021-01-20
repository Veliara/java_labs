package com.company;

public class StringWork {
    private final String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private String str;

    StringWork() {}

    StringWork(String s) {
        str = s;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    // Отдает номер буквы в алфавите
    private int getNumOfLetter(char c) {
        return alphabet.indexOf(Character.toLowerCase(c)) + 1;
    }

    // Отдает строку с пробелами между символами (выводит только буквы)
    public String getNewStr() {
        StringBuilder res = new StringBuilder();
        char[] arr = getStr().toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if (Character.isLetter(arr[i])) {
                res.append("  " + arr[i]);
            }
        }
        return res.toString();
    }

    // Отдает строку с номерами букв
    public String getNewNumericStr() {
        StringBuilder res = new StringBuilder();
        char[] arr = getStr().toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if (Character.isLetter(arr[i])) {
                res.append(String.format("%3d", getNumOfLetter(arr[i])));
            }
        }
        return res.toString();
    }
}
