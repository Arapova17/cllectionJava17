package task_slack.pharmacy_management_system.service;

import task_slack.pharmacy_management_system.models.Employee;

import java.util.List;

public interface EmployeeService {
    void createEmployee(Employee employee);
    void assignEmployeeToPharmacy(String pharmacyId, String employeeEmail);
    void getEmployeesByPharmacy(String pharmacyId);
    void updateEmployee(String employeeId, Employee updatedEmployee);
    void deleteEmployee(String employeeId);
    void getAllEmployees();
}
