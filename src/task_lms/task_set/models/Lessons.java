package task_lms.task_set.models;

public class Lessons {
    private String lesson;

    public Lessons() {
    }

    public Lessons(String lesson) {
        this.lesson = lesson;
    }

    public String lesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    @Override
    public String toString() {
        return "Lessons{" +
                "lesson='" + lesson + '\'' +
                '}';
    }
}
