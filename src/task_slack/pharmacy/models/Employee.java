package task_slack.pharmacy.models;

import task_slack.pharmacy.enums.Gender;
import task_slack.pharmacy.enums.Position;

public class Employee {
    private static Long count = 1L;
    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private double experience;
    private Position position;
    private Gender gender;

    public Employee() {
    }

    public Employee(String fullName, String email, String phoneNumber,
                    double experience, Position position, Gender gender) {
        this.id = count++;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.experience = experience;
        this.position = position;
        this.gender = gender;
    }

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String fullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String phoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double experience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public Position position() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Gender gender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee" +
                " id = " + id +
                " full Name = " + fullName +
                " email = " + email +
                " phone Number = " + phoneNumber +
                " experience = " + experience +
                " position = " + position +
                " gender = " + gender ;
    }
}
