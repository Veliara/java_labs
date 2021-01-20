package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringWorkTest {
    StringWork sw;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        sw = new StringWork();
    }

    @Test
    void getNewStrTest() {
        sw.setStr("Привет мир!");
        String expected = "  П  р  и  в  е  т  м  и  р";
        assertEquals(expected, sw.getNewStr(), "Неправильная обработка строки");
    }

    @Test
    void getNewNumericStrTest() {
        sw.setStr("Привет мир!");
        String expected = " 17 18 10  3  6 20 14 10 18";
        assertEquals(expected, sw.getNewNumericStr(), "Неправильная обработка строки");
    }
}