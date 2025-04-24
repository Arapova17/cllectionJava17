package task_slack.pharmacy;

import task_slack.pharmacy.database.Database;
import task_slack.pharmacy.enums.Gender;
import task_slack.pharmacy.enums.Position;
import task_slack.pharmacy.models.Employee;
import task_slack.pharmacy.models.Medicine;
import task_slack.pharmacy.models.Pharmacy;
import task_slack.pharmacy.service.EmployeeService;
import task_slack.pharmacy.service.MedicineService;
import task_slack.pharmacy.service.PharmacyService;
import task_slack.pharmacy.service.serviceImpl.EmployeeServiceImpl;
import task_slack.pharmacy.service.serviceImpl.MedicineServiceImpl;
import task_slack.pharmacy.service.serviceImpl.PharmacyServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MedicineService medicineService = new MedicineServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        PharmacyService pharmacyService = new PharmacyServiceImpl();

        Employee employee = new Employee();

        while (true) {
            System.out.println("""
                    \n====== MENU ======
                    1. Add Pharmacy
                    2. Add Employee
                    3. Assign Employee to Pharmacy
                    4. Add Medicine to Pharmacy
                    5. Assign Medicine to Pharmacy
                    6. Show Employees by Pharmacy ID
                    7. Show Medicines by Pharmacy ID
                    8. Delete Employee
                    9. Get By Id Employee
                    0. Exit
                    ==================
                    Choose:
                    """);

            int choice = new Scanner(System.in).nextInt();

            switch (choice) {
                case 1:
                    try {
                        System.out.println("Pharmacy name: ");
                        String name = new Scanner(System.in).nextLine();
                        System.out.println("Pharmacy address: ");
                        String address = new Scanner(System.in).nextLine();

                        System.out.println(pharmacyService.addPharmacy(new Pharmacy(name, address)));
                        System.out.println(pharmacyService.getAllPharmacy());
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 2:
                    try {
                        System.out.println("Full name: ");
                        String fullName = new Scanner(System.in).nextLine();
                        System.out.println("Email: ");
                        String email = new Scanner(System.in).nextLine();
                        try {
                            if (!email.contains("@")) {
                                throw new RuntimeException("*gmail сөзсүз түрдү @ символун камтышы керек.");
                            } else {
                                employee.setEmail(email);
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println("Phone: ");
                        String phone = new Scanner(System.in).nextLine();
                        try {
                            if (!phone.matches("\\+996\\d{9}")) {
                                throw new RuntimeException("*Телефон номер сөзсүз түрдө +996 менен башталышы керек жана 13\n" +
                                        "цифрадан турушу керек ");
                            } else {
                                employee.setPhoneNumber(phone);
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        try {
                            System.out.println("Experience: ");
                            double experience = new Scanner(System.in).nextDouble();
                            System.out.println("Position (ADMIN / PHARMACIST / TELLER): ");
                            Position position = Position.valueOf(new Scanner(System.in).nextLine().toUpperCase());
                            System.out.println("MALE/FEMALE");
                            Gender gender = Gender.valueOf(new Scanner(System.in).nextLine().toUpperCase());
                            System.out.println(employeeService.addEmployee(new Employee(fullName, email,
                                    phone, experience, position, gender)));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println(employeeService.getAllEmployee());
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 3:
                    try {
                        System.out.println("Assign Employee id: ");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println("Pharmacy id: ");
                        Long pharmacyId = new Scanner(System.in).nextLong();

                        System.out.println(employeeService.assignEmployeeToPharmacy(id, pharmacyId));
                        System.out.println(employeeService.getAllEmployee());
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 4:
                    try {
                        System.out.println("Medicine name: ");
                        String nameMedicine = new Scanner(System.in).nextLine();
                        System.out.println("Price: ");
                        int price = new Scanner(System.in).nextInt();
                        System.out.println("Description: ");
                        String desc = new Scanner(System.in).nextLine();
                        System.out.println("Expiration year (only 2025 accepted): ");
                        int year = new Scanner(System.in).nextInt();
                        LocalDate expDate = LocalDate.of(year, 1, 1);
                        System.out.println(medicineService.addMedicine(new Medicine(nameMedicine, price, desc, expDate)));
                        System.out.println(medicineService.getAllMedicine());
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 5:
                    try {
                        System.out.println("Assign Medicine id: ");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println("Pharmacy id: ");
                        Long pharmacy = new Scanner(System.in).nextLong();

                        System.out.println(medicineService.assignMedicineToPharmacy(id, pharmacy));
                        System.out.println(medicineService.getAllMedicine());
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 6:
                    try {
                        System.out.println("Pharmacy id: ");
                        Long idPharmacy = new Scanner(System.in).nextLong();
                        List<Employee> employees = pharmacyService.getEmployeesByPharmacyId(idPharmacy);
                        for (Employee employee1 : employees) {
                            System.out.println(employee1);
                        }
                        System.out.println(employeeService.getAllEmployee());
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 7:
                    try {
                        Scanner scanner = new Scanner(System.in);

                        System.out.println("Pharmacy id: ");
                        Long pharmacyId = scanner.nextLong();

                        List<Medicine> medicines = pharmacyService.getMedicinesByPharmacyId(pharmacyId);

                        if (medicines.isEmpty()) {
                            System.out.println("No medicines found for this pharmacy.");
                        } else {
                            medicines.forEach(System.out::println);
                        }

                        System.out.println(medicineService.getAllMedicine());

                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                case 8:
                    try {
                        System.out.println("Delete Employee");
                        System.out.println("Write id: ");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println(employeeService.deleteEmployee(id));
                        break;
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                case 9:
                    try {
                        System.out.println("Get By Id Employee");
                        System.out.println("Write id: ");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println(employeeService.getByIdEmployee(id));
                        break;
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                case 10:
                    try {
                        System.out.println("Update Employee");
                        System.out.println("Write id: ");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println("Full name: ");
                        String fullName = new Scanner(System.in).nextLine();
                        System.out.println("Email: ");
                        String email = new Scanner(System.in).nextLine();
                        try {
                            if (!email.contains("@")) {
                                throw new RuntimeException("*gmail сөзсүз түрдү @ символун камтышы керек.");
                            } else {
                                employee.setEmail(email);
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println("Phone: ");
                        String phone = new Scanner(System.in).nextLine();
                        try {
                            if (!phone.matches("\\+996\\d{9}")) {
                                throw new RuntimeException("*Телефон номер сөзсүз түрдө +996 менен башталышы керек жана 13\n" +
                                        "цифрадан турушу керек ");
                            } else {
                                employee.setPhoneNumber(phone);
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        try {
                            System.out.println("Experience: ");
                            double experience = new Scanner(System.in).nextDouble();
                            System.out.println("Position (ADMIN / PHARMACIST / TELLER): ");
                            Position position = Position.valueOf(new Scanner(System.in).nextLine().toUpperCase());
                            System.out.println("MALE/FEMALE");
                            Gender gender = Gender.valueOf(new Scanner(System.in).nextLine().toUpperCase());
                            System.out.println(employeeService.updateEmployee(id, new Employee(fullName, email,
                                    phone, experience, position, gender)));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println(employeeService.getAllEmployee());
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 0:
                    try {
                        System.out.println("Goodbye!");
                        return;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                default:
                    System.out.println("Invalid choice.");
            }
        }


    }
}
