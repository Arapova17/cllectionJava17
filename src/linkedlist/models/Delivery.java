package linkedlist.models;

import linkedlist.enums.DeliveryStatus;

import java.time.LocalDate;

public class Delivery {
    private Long id;
    private String address;
    private LocalDate deliveryDate;
    private double price;
    private DeliveryStatus deliveryStatus;
    private Package aPackage;
    private Courier courier;

    public Delivery() {
    }

    public Delivery(Long id, String address, LocalDate deliveryDate, double price, DeliveryStatus deliveryStatus) {
        this.id = id;
        this.address = address;
        this.deliveryDate = deliveryDate;
        this.price = price;
        this.deliveryStatus = deliveryStatus;
    }

    public Delivery(Long id, String address, LocalDate deliveryDate,
                    double price, DeliveryStatus deliveryStatus, Package aPackage, Courier courier) {
        this.id = id;
        this.address = address;
        this.deliveryDate = deliveryDate;
        this.price = price;
        this.deliveryStatus = deliveryStatus;
        this.aPackage = aPackage;
        this.courier = courier;
    }

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String address() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate deliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public double price() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DeliveryStatus deliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Package aPackage() {
        return aPackage;
    }

    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }

    public Courier courier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", price=" + price +
                ", deliveryStatus=" + deliveryStatus +
                ", aPackage=" + aPackage +
                ", courier=" + courier +
                '}';
    }
}
