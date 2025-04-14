package linkedlist;

import linkedlist.database.Database;
import linkedlist.database.GenerateId;
import linkedlist.enums.DeliveryStatus;
import linkedlist.models.Courier;
import linkedlist.models.Delivery;
import linkedlist.service.DeliveryService;
import linkedlist.service.serviceImpl.DeliveryServiceImpl;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryServiceImpl();

        Delivery delivery = new Delivery(GenerateId.genDeliveryId(), "Vostoc 5",
                LocalDate.of(2025, 4, 16), 100, DeliveryStatus.WAITING);
        Delivery delivery1 = new Delivery(GenerateId.genDeliveryId(), "Vostoc 5",
                LocalDate.of(2025, 4, 16), 100, DeliveryStatus.WAITING);

        Courier courier = new Courier(GenerateId.genCourierId(), "Shyngyz", 3, true);

        Database.couriers.add(courier);

        System.out.println(deliveryService.addDelivery(delivery));

        System.out.println(Database.deliveries);

        System.out.println(deliveryService.assignCourierToDeliveryId(1L, 1L));

        System.out.println(Database.deliveries);

    }
}
