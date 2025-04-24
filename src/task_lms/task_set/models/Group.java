package task_lms.task_set.models;

import task_lms.task_set.enums.Lessons;

import java.util.List;

public class Group {
    private static Long count = 0L;
    private Long id;
    private String groupName;
    private String description;
    private Lessons lessons;
    private List<Students> students;

    public Group() {
    }

    public Group(String groupName, String description, Lessons lessons, List<Students> students) {
        this.id = ++count;
        this.groupName = groupName;
        this.description = description;
        this.lessons = lessons;
        this.students = students;
    }

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String groupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String description() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Lessons lessons() {
        return lessons;
    }

    public void setLessons(Lessons lessons) {
        this.lessons = lessons;
    }

    public List<Students> students() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", description='" + description + '\'' +
                ", lessons=" + lessons +
                ", students=" + students +
                '}';
    }
}
