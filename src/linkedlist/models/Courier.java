package linkedlist.models;

public class Courier {
    private static Long count = 0L;
    private Long id;
    private String fullName;
    private double rating;
    private boolean isAvailing;

    public Courier() {
    }

    public Courier( String fullName, double rating, boolean isAvailing) {
        this.id = ++count;
        this.fullName = fullName;
        this.rating = rating;
        this.isAvailing = isAvailing;
    }

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String fullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double rating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isAvailing() {
        return isAvailing;
    }

    public void setAvailing(boolean availing) {
        isAvailing = availing;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", rating=" + rating +
                ", isAvailing=" + isAvailing +
                '}';
    }
}
