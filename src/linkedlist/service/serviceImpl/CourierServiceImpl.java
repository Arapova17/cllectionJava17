package linkedlist.service.serviceImpl;

import linkedlist.database.Database;
import linkedlist.models.Courier;
import linkedlist.service.CourierService;

import java.util.List;

public class CourierServiceImpl implements CourierService {

    @Override
    public String addCourier(Courier courier) {
        Database.couriers.add(courier);
        return "SuccessFull added!";
    }

    @Override
    public Courier getAvailableCourier(boolean isTrue) {
        for (Courier courier : Database.couriers) {
            if (courier.isAvailing()) {
                courier.setAvailing(isTrue);
                return courier;
            }
        }
        return null;
    }

    @Override
    public List<Courier> getAvailableCouriers() {
        for (Courier courier : Database.couriers) {
            if (courier.isAvailing()) {
                return Database.couriers;
            }
        }
        return null;
    }

    @Override
    public List<Courier> getAllCouriers() {
        return Database.couriers;
    }

    @Override
    public List<Courier> getCouriersByRating(double minRating) {
        for (Courier courier : Database.couriers){
            if (courier.rating() <= minRating){
                return Database.couriers;
            }
        }
        return Database.couriers;
    }

    @Override
    public String updateCourierStatus(Long id, boolean isAvailable) {
        for (Courier courier : Database.couriers){
            if (courier.id().equals(id)){
                if (courier.isAvailing()){
                    courier.setAvailing(isAvailable);
                    return "Success!";
                }
            }
        }
        return "not found";
    }

    @Override
    public void setCourierRating(Long id, double newRating) {
        for (Courier courier : Database.couriers){
            if (courier.id().equals(id)){
                courier.setRating(newRating);
                System.out.println(newRating);
            }
        }
    }
}
