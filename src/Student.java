public class Student {
    private String name;
    private Integer age;
    private String group;

    public Student() {
    }

    public Student(String name, Integer age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer age() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String group() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "\nStudent" +
                " name = " + name +
                " age = " + age +
                " group = " + group ;
    }
}
