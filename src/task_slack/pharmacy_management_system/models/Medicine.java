package task_slack.pharmacy_management_system.models;

import java.time.LocalDate;
import java.util.UUID;

public class Medicine {
    private final String id = UUID.randomUUID().toString();
    private String name;
    private int price;
    private String description;
    private LocalDate expirationDate;

    public Medicine() {
    }

    public Medicine(String name, int price, String description, LocalDate expirationDate) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.expirationDate = expirationDate;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int price() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String description() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate expirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
