package task_slack.pharmacy.database;

import task_slack.pharmacy.models.Employee;
import task_slack.pharmacy.models.Medicine;
import task_slack.pharmacy.models.Pharmacy;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Pharmacy> pharmacies = new ArrayList<>();
    public static List<Employee> employees = new ArrayList<>();
    public static List<Medicine> medicines = new ArrayList<>();
}
