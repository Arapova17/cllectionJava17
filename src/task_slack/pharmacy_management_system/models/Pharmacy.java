package task_slack.pharmacy_management_system.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pharmacy {
    private final String id = UUID.randomUUID().toString();
    private String name;
    private String address;
    private List<Employee> employees = new ArrayList<>();
    private List<Medicine> medicines = new ArrayList<>();

    public Pharmacy() {
    }

    public Pharmacy(String name, String address, List<Employee> employees, List<Medicine> medicines) {
        this.name = name;
        this.address = address;
        this.employees = employees;
        this.medicines = medicines;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String address() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Employee> employees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Medicine> medicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", employees=" + employees +
                ", medicines=" + medicines +
                '}';
    }
}
