package task_lms.task_map.models;

import task_lms.task_map.enums.Category;
import task_lms.task_map.enums.KeyCharacter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Product {
    private static Long count = 0L;
    private Long id;
    private Category category;
    private String name;
    private List<Map<KeyCharacter, String>> characters = new ArrayList<>();
    private double price;

    public Product() {
    }

    public Product(String name, Category category, double price) {
        this.id = ++count;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Product(Category category, String name, double price) {
        this.id = ++count;
        this.category = category;
        this.name = name;
        this.characters = new ArrayList<>();
        this.price = price;
    }

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category category() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map<KeyCharacter, String>> characters() {
        return characters;
    }

    public void setCharacters(List<Map<KeyCharacter, String>> characters) {
        this.characters = characters;
    }

    public double price() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addCharacter(Map<KeyCharacter, String> character) {
        if (this.characters == null) {
            this.characters = new ArrayList<>();
        }
        this.characters.add(character);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", characters=" + characters +
                ", price=" + price +
                '}';
    }
}
