package task_lms.task_set.service;

import task_lms.task_set.models.Lessons;

import java.util.List;

public interface LessonService {
    String addNewLessons (Lessons lessons);
    List<Lessons> getAllLessonsByName (String name);
    List<Lessons> getAllLessonsByGroup (String groupName);
    String deleteLessons (String name);
}
