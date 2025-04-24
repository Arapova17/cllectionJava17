package task_slack.pharmacy.models;

import java.time.LocalDate;

public class Medicine {
    private static Long count = 1L;
    private Long id;
    private String name;
    private int price;
    private String description;
    private LocalDate expirationDate;

    public Medicine() {
    }

    public Medicine(String name, int price, String description, LocalDate expirationDate) {
        this.id = count++;
        this.name = name;
        this.price = price;
        this.description = description;
        this.expirationDate = expirationDate;
    }

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        try {
            if (expirationDate.compareTo(LocalDate.now()) < 0 && expirationDate != null) {
                throw new RuntimeException("Мөөнөтү өтүп кеткен!");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Medicine" +
                ": id = " + id +
                ": name = " + name +
                ": price = " + price +
                ": description = " + description +
                ": expiration Date = " + expirationDate + "\n";
    }
}
