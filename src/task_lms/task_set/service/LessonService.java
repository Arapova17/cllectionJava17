package task_lms.task_set.service;

import task_lms.task_set.enums.Lessons;

import java.util.List;

public interface LessonService {
    String addNewLessons (Lessons lessons);
    List<Lessons> getAllLessonsByName ();
    List<Lessons> getAllLessonsByGroup ();
    String deleteLessons (Lessons name);
}
