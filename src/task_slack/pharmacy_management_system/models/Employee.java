package task_slack.pharmacy_management_system.models;

import task_slack.pharmacy_management_system.enums.Gender;
import task_slack.pharmacy_management_system.enums.Position;

import java.util.UUID;

public class Employee {
    private final String id = UUID.randomUUID().toString(); // Auto-generated
    private String fullName;
    private String email;
    private String phoneNumber;
    private double experience;
    private Position position;
    private Gender gender;

    public Employee() {
    }

    public Employee(String fullName, String email, String phoneNumber, double experience, Position position, Gender gender) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.experience = experience;
        this.position = position;
        this.gender = gender;
    }

    public String id() {
        return id;
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
        return "EmployeeService{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", experience=" + experience +
                ", position=" + position +
                ", gender=" + gender +
                '}';
    }
}
