package task_slack.pharmacy.models;

import java.util.ArrayList;
import java.util.List;

public class Pharmacy {
    private static Long count = 1L;
    private Long id;
    private String name;
    private String address;
    private List<Employee> employees;
    private List<Medicine> medicines;

    public Pharmacy() {
    }

    public Pharmacy(String name, String address) {
        this.id = count++;
        this.name = name;
        this.address = address;
        this.medicines = new ArrayList<>();
    }

    public Pharmacy(String name, String address, List<Employee> employees, List<Medicine> medicines) {
        this.id = count++;
        this.name = name;
        this.address = address;
        this.employees = employees;
        this.medicines = medicines;
    }

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "Pharmacy" +
                " id = " + id +
                " name = " + name +
                " address = " + address +
                " employees = " + employees +
                " medicines = " + medicines ;
    }
}
