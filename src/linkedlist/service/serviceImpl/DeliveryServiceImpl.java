package linkedlist.service.serviceImpl;

import linkedlist.database.Database;
import linkedlist.enums.DeliveryStatus;
import linkedlist.models.Courier;
import linkedlist.models.Delivery;
import linkedlist.service.DeliveryService;

import java.util.LinkedList;
import java.util.List;

public class DeliveryServiceImpl implements DeliveryService {
    @Override
    public String addDelivery(Delivery delivery) {
        Database.deliveries.add(delivery);
        return "Successfully added!";
    }

    @Override
    public String deleteDelivery(Long id) {
        for (Delivery delivery : Database.deliveries) {
            if (delivery.id().equals(id)) {
                Database.deliveries.remove(delivery);
                return "Successfully delete";
            }
        }
        return "Id is not fount";
    }

    @Override
    public List<Delivery> getDeliveriesByStatus(DeliveryStatus status) {
        List<Delivery> deliveriesResult = new LinkedList<>();
        for (Delivery delivery : Database.deliveries){
            if (delivery.deliveryStatus().equals(status)) {
                deliveriesResult.add(delivery);
            }
        }
        return deliveriesResult;
    }

    @Override
    public Delivery getDeliveriesByCourierId(Long courierId) {
        for (Delivery delivery : Database.deliveries) {
            if (delivery.courier().id().equals(courierId)) {
                return delivery;
            }
        }
        return null;
    }

    @Override
    public String updateDeliveryStatus(Long id, DeliveryStatus newStatus) {
        for (Delivery delivery : Database.deliveries) {
            if (delivery.id().equals(id)) {
                delivery.setDeliveryStatus(newStatus);
                return "status successfully update";
            }
        }
        return "Delivery is not found!";
    }

    @Override
    public String assignCourierToDeliveryId(Long deliveryId, Long courierId) {
        for (Delivery delivery : Database.deliveries) {
            if (delivery.id().equals(deliveryId)) {
                for (Courier courier : Database.couriers) {
                    if (courier.id().equals(courierId)) {
                        delivery.setCourier(courier);
                        return "Success!";
                    }
                }
            }
        }
        return "Id is not found";
    }
}
