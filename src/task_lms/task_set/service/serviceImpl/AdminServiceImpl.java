package task_lms.task_set.service.serviceImpl;

import task_lms.task_set.models.Admin;
import task_lms.task_set.service.AdminService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdminServiceImpl implements AdminService {
    @Override
    public Map<String, String> registerAdmin() {
        Scanner scanner = new Scanner(System.in);

        // Катталган колдонуучулар (почта -> сырсөз)
        Map<String, String> registerAdmin = new HashMap<>();
        Admin admin = new Admin();
        registerAdmin.put("test@gmail.com", "123456");

        System.out.println("Эгер катталган болсоңуз, 1 басыңыз.");
        System.out.println("Эгер сырсөзүңүздү унутуп калган болсоңуз, өзгөртүү үчүн 2 басыңыз.");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Enter баскычын кармап калбоо үчүн

        switch (choice) {
            case 1:
                try {
                    System.out.print("Почтаңызды киргизиңиз: ");
                    String email = scanner.nextLine();
                    try {
                        if (!email.contains("@")) {
                            throw new RuntimeException("*gmail сөзсүз түрдү @ символун камтышы керек.");
                        } else {
                            admin.setEmail(email);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    System.out.print("Сырсөздү киргизиңиз: ");
                    String password = scanner.nextLine();
                    try {
                        if (!password.matches("\\d{6}")) {
                            throw new RuntimeException("Сырсөздү 6 символ камтышы керек.");
                        } else {
                            admin.setPassword(password);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    if (registerAdmin.containsKey(email) && registerAdmin.get(email).equals(password)) {
                        System.out.println("Кош келиңиз, " + email + "!");
                    } else {
                        System.out.println("Почта же сырсөз туура эмес!");
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                System.out.print("Почтаңызды киргизиңиз: ");
                String resetEmail = scanner.nextLine();

                if (registerAdmin.containsKey(resetEmail)) {
                    System.out.print("Эски сырсөздү киргизиңиз: ");
                    String oldPassword = scanner.nextLine();

                    if (registerAdmin.get(resetEmail).equals(oldPassword)) {
                        System.out.print("Жаңы сырсөздү киргизиңиз: ");
                        String newPassword = scanner.nextLine();

                        registerAdmin.put(resetEmail, newPassword);
                        System.out.println("Сырсөз ийгиликтүү өзгөртүлдү!");
                    } else {
                        System.out.println("Эски сырсөз туура эмес!");
                    }
                } else {
                    System.out.println("Бул почта катталган эмес!");
                }
                break;

            default:
                System.out.println("Туура эмес тандоо.");
        }

        return registerAdmin;
    }
}
