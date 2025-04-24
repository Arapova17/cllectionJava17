package linkedlist;

import linkedlist.database.Database;
import linkedlist.database.GenerateId;
import linkedlist.enums.DeliveryStatus;
import linkedlist.enums.PackageType;
import linkedlist.models.Courier;
import linkedlist.models.Delivery;
import linkedlist.models.Package;
import linkedlist.service.CourierService;
import linkedlist.service.DeliveryService;
import linkedlist.service.PackageService;
import linkedlist.service.serviceImpl.CourierServiceImpl;
import linkedlist.service.serviceImpl.DeliveryServiceImpl;
import linkedlist.service.serviceImpl.PackageServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryServiceImpl();
        CourierService courierService = new CourierServiceImpl();
        PackageService packageService = new PackageServiceImpl();

        while (true) {
            System.out.println("\n~~~~~~~~MENU~~~~~~~~" +
                    """
                            1. Add Courier
                            2. get Available Courier
                            3. get Available Couriers
                            4. get All Couriers
                            5. get Couriers By Rating
                            6. update Courier Status
                            7. set Courier Rating
                            8. add Delivery
                            9. delete Delivery
                            10. get Deliveries By Status
                            11. get Deliveries By Courier Id
                            12. update Delivery Status
                            13. assign Courier To Delivery Id
                            14. create package
                            15. sort package by type
                            16. sort package by weight
                          """);
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    try {
                        System.out.println("name: ");
                        String name = new Scanner(System.in).nextLine();
                        System.out.println("rating: ");
                        double rating = new Scanner(System.in).nextDouble();
                        System.out.println("is availing: ");
                        boolean is = new Scanner(System.in).hasNext();
                        System.out.println(courierService.addCourier(new Courier(name, rating, is)));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println(courierService.getAvailableCourier(true));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println(courierService.getAvailableCouriers());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println(courierService.getAllCouriers());
                    break;
                case 5:
                    try {
                        System.out.println("rating: ");
                        double rating = new Scanner(System.in).nextDouble();
                        System.out.println(courierService.getCouriersByRating(rating));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        System.out.println("write id: ");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println("new is availing: ");
                        boolean is = new Scanner(System.in).hasNext();
                        courierService.updateCourierStatus(id, is);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        System.out.println("write id: ");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println("write rating: ");
                        double rating = new Scanner(System.in).nextDouble();
                        courierService.setCourierRating(id, rating);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        System.out.println("address: ");
                        String address = new Scanner(System.in).nextLine();
                        System.out.println("price: ");
                        int price = new Scanner(System.in).nextInt();
                        System.out.println("status (WAITING, IN_TRANSIT, DELIVERED): ");
                        DeliveryStatus deliveryStatus = DeliveryStatus.valueOf(new Scanner(System.in).nextLine().toUpperCase());
                        System.out.println(deliveryService.addDelivery(new Delivery(address,
                                LocalDate.of(2025, 1, 2), price, deliveryStatus)));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    try {
                        System.out.println("delete id: ");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println(deliveryService.deleteDelivery(id));
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 10:
                    try {
                        System.out.println("get Deliveries By Status ");
                        DeliveryStatus deliveryStatus = DeliveryStatus.valueOf(new Scanner(System.in).nextLine());
                        System.out.println(deliveryService.getDeliveriesByStatus(deliveryStatus));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 11:
                    try {
                        System.out.println("get Deliveries By Courier Id");
                        System.out.println("Deliveries Id");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println("Courier Id");
                        Long idCourier = new Scanner(System.in).nextLong();
                        System.out.println(deliveryService.assignCourierToDeliveryId(id, idCourier));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 12:
                    try {
                        System.out.println("Deliveries Id");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println("update Delivery Status");
                        DeliveryStatus deliveryStatus = DeliveryStatus.valueOf(new Scanner(System.in).nextLine());
                        System.out.println(deliveryService.updateDeliveryStatus(id, deliveryStatus));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 13:
                    try {
                        System.out.println("assign Courier To Delivery Id");
                        System.out.println("Deliveries Id");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println("Courier Id");
                        Long idCourier = new Scanner(System.in).nextLong();
                        System.out.println(deliveryService.assignCourierToDeliveryId(id, idCourier));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 14:
                    try {
                        System.out.println("create package");
                        System.out.println("Weight: ");
                        double weight = new Scanner(System.in).nextDouble();
                        System.out.println("Type: ");
                        PackageType packageType = PackageType.valueOf(new Scanner(System.in).nextLine());
                        System.out.println(packageService.createPackage(new Package(weight, packageType)));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 15:
                    try {
                        System.out.println(" sort package by type");
                        System.out.println(packageService.sortPackageByType());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 16:
                    try {
                        System.out.println("sort package by weight");
                        System.out.println(packageService.sortPackageByWeight());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

    }
}
