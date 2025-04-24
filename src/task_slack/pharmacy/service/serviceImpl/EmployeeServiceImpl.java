package task_slack.pharmacy.service.serviceImpl;

import task_slack.pharmacy.database.Database;
import task_slack.pharmacy.models.Employee;
import task_slack.pharmacy.models.Pharmacy;
import task_slack.pharmacy.service.EmployeeService;

import java.awt.dnd.DropTarget;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public String addEmployee(Employee employee) {
        try {
            for (Employee employee1 : Database.employees){
                if (employee1.email().equalsIgnoreCase(employee.email())){
                    throw new RuntimeException("This email already exists!");
                }
            }
            Database.employees.add(employee);
            return "Success!";
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        try {
            return Database.employees;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee getByIdEmployee(Long id) {
        try {
            for (Employee employee : Database.employees) {
                if (employee.id().equals(id)) {
                    return employee;
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public String updateEmployee(Long id, Employee newEmployee) {
        try {
            for (Employee employee : Database.employees) {
                employee.setFullName(newEmployee.fullName());
                employee.setEmail(newEmployee.email());
                employee.setPhoneNumber(newEmployee.phoneNumber());
                employee.setExperience(newEmployee.experience());
                employee.setPosition(newEmployee.position());
                employee.setGender(newEmployee.gender());
                return "Success!";
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return "not found!";
    }

    @Override
    public String deleteEmployee(Long id) {
        try {
            for (Employee employee : Database.employees) {
                if (employee.id().equals(id)) {
                    Database.employees.remove(employee);
                    return "Success!";
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return "not found!";
    }

    @Override
    public String assignEmployeeToPharmacy(Long employeeId, Long pharmacyId) {
        try {
            for (Pharmacy pharmacy : Database.pharmacies) {
                if (pharmacy.id().equals(pharmacyId)) {
                    for (Employee employee : Database.employees) {
                        if (employee.id().equals(employeeId)) {
                            pharmacy.setEmployees(Database.employees);
                            return "Success!";
                        }
                    }
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return "not found!";
    }
}
