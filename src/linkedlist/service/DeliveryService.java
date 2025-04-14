package linkedlist.service;

import linkedlist.enums.DeliveryStatus;
import linkedlist.models.Delivery;

import java.util.List;

public interface DeliveryService {
    String addDelivery(Delivery delivery);
    String deleteDelivery(Long id);
    List<Delivery> getDeliveriesByStatus(DeliveryStatus status);
    Delivery getDeliveriesByCourierId(Long courierId);
    String updateDeliveryStatus(Long id, DeliveryStatus newStatus);
    String assignCourierToDeliveryId(Long deliveryId, Long courierId);
}
