package task_lms.task_map;

import task_lms.task_map.enums.Category;
import task_lms.task_map.enums.KeyCharacter;
import task_lms.task_map.models.Product;
import task_lms.task_map.service.ProductService;
import task_lms.task_map.service.serviceImpl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Save Product");
            System.out.println("2. Search By Product Name");
            System.out.println("3. Sort By Character");
            System.out.println("4. Filter By Character");
            System.out.println("5. Get By Id Product");
            System.out.println("6. Update Product");
            System.out.println("7. Delete All Character");
            System.out.println("8.  Delete By Product");
            System.out.println("9. Delete Character By Key Name");
            System.out.println("10. Get All Product");
            System.out.println("0. Exit");
            System.out.print("Write: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    try {

                        System.out.println("Product name: ");
                        String name = scanner.next();
                        System.out.println("Product category (phone, laptop, smartWatch): ");
                        Category category = Category.valueOf(scanner.next());
                        System.out.println("Product price: ");
                        double price = scanner.nextDouble();
                        Product newProduct = new Product(name, category, price);
                        productService.saveProduct(newProduct);
                        System.out.println("Success!");
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 2:
                    try {
                        System.out.println("Product name: ");
                        String name = scanner.next();
                        List<Product> result = productService.searchByProductName(name);
                        for (Product product : result){
                            System.out.println(product);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Key character: ");
                        String key = scanner.next();
                        KeyCharacter keyCharacter = KeyCharacter.valueOf(key.toUpperCase());
                        System.out.println(productService.sortByCharacter(keyCharacter));
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 4:
                    try {
                        System.out.println("Key character: ");
                        String key = scanner.next();
                        KeyCharacter keyCharacter = KeyCharacter.valueOf(key.toUpperCase());
                        System.out.println("Value: ");
                        String name = new Scanner(System.in).nextLine();
                        System.out.println(productService.filterByCharacter(keyCharacter, name));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 5:
                    try {
                        System.out.println("Product ID: ");
                        Long productId = scanner.nextLong();
                        Product product = productService.getByIdProduct(productId);
                        if (product != null) {
                            System.out.println(product);
                        } else {
                            System.out.println("Not found.");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        System.out.println("Product ID: ");
                        Long productId = scanner.nextLong();
                        System.out.println("Product name: ");
                        String name = scanner.next();
                        System.out.println("Product category (phone, laptop, smartWatch): ");
                        Category category = Category.valueOf(scanner.next());
                        System.out.println("Product price: ");
                        double price = scanner.nextDouble();
                        productService.updateProduct(productId, new Product(name, category, price));
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 7:
                    try {
                        System.out.println("Product ID: ");
                        Long productId = scanner.nextLong();
                        productService.deleteAllCharacters(productId);
                        System.out.println("Delete!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        System.out.println("Product ID: ");
                        Long productId = scanner.nextLong();
                        productService.deleteByProduct(productId);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 9:
                    try {
                        System.out.println("Product ID: ");
                        Long productId = scanner.nextLong();
                        System.out.println("Key character: ");
                        String key = scanner.next();
                        KeyCharacter keyCharacter = KeyCharacter.valueOf(key.toUpperCase());
                        productService.deleteCharacterByKeyName(productId, keyCharacter);
                        System.out.println("Success!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 10:
                    try {
                        System.out.println(productService.getAllProduct());
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Not found");
                    break;
            }
        } while (choice != 0);

    }
}
