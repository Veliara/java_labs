package com.company;

public class Student extends Human {
    private String faculty;
    private int course;
    private String group;

    Student() {}

    Student(int id, String surname, String name, String patronymic, String birthday, String address, String phone, String faculty, int course, String group) {
        super(id, surname, name, patronymic, birthday, address, phone);
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }


    public String getFaculty() { return faculty; }
    public void setFaculty(String faculty) { this.faculty = faculty; }

    public int getCourse() { return course; }
    public void setCourse(int course) { this.course = course; }

    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    @Override
    public String toString() {
        return "" + getId() + ": " + getSurname() + " " + getName() + " " + getPatronymic() + ", " + getBirthday() + ", "
                + getAddress() + ", " + getPhone() + ", " + getFaculty() + ", " + getCourse() + " курс, группа " + getGroup();
    }
}
