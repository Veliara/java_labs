package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student student;

    @BeforeEach
    void setUp() {
        student = new Student();
    }

    @Test
    void setBirthdayTest() {
        String s = "12.12.2000";
        int expected = 2000;
        student.setBirthday(s);
        assertEquals(expected, student.getBirthYear(), "FUCK!!!");
    }

    @Test
    void getBirthdayTest() {
        String s = "12.12.2000";
        student.setBirthday(s);
        assertEquals(s, student.getBirthday(), "FUCK!!!");
    }
}