package com.company;

public class Teacher extends Human {
    private String subject;
    private String position;

    Teacher() {}

    Teacher(int id, String surname, String name, String patronymic,
            String birthday, String address, String phone, String subject, String position) {
        super(id, surname, name, patronymic, birthday, address, phone);
        this.subject = subject;
        this.position = position;
    }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getPosition() { return position;};
    public void setPosition(String position) { this.position = position;}

    @Override
    public String toString() {
        return "" + getId() + ": " + getSurname() + " " + getName() + " " + getPatronymic() + ", " + getBirthday() + ", "
                + getAddress() + ", " + getPhone() + "; Читает " + getSubject() + ", " + getPosition();
    }

}
