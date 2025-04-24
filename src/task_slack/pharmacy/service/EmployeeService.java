package task_slack.pharmacy.service;

import task_slack.pharmacy.models.Employee;

import java.util.List;

public interface EmployeeService {
    String addEmployee (Employee employee);
    List<Employee> getAllEmployee();
    Employee getByIdEmployee (Long id);
    String updateEmployee (Long id, Employee newEmployee);
    String deleteEmployee (Long id);
    String assignEmployeeToPharmacy (Long employeeId, Long pharmacyId);
}
