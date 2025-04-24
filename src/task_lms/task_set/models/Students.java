package task_lms.task_set.models;

public class Students {
    private static Long count = 0L;
    private Long id;
    private String name;
    private int age;
    private String email;
    private String password;

    public Students() {
    }

    public Students(String name, int age, String email, String password) {
        this.id = ++count;
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
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

    public int age() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String password() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
