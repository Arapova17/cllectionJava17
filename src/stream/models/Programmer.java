package stream.models;

import stream.enums.Language;

public class Programmer {
    private static Long count = 0L;
    private Long id;
    private String name;
    private double salary;
    private Language language;

    public Programmer() {
    }

    public Programmer( String name, double salary, Language language) {
        this.id = ++count;
        this.name = name;
        this.salary = salary;
        this.language = language;
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

    public double salary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Language language() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", language=" + language +
                '}';
    }
}
