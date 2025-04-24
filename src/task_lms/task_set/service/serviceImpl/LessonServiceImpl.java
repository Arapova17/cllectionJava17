package task_lms.task_set.service.serviceImpl;

import task_lms.task_set.enums.Lessons;
import task_lms.task_set.service.LessonService;

import java.util.List;

public class LessonServiceImpl implements LessonService {
    @Override
    public String addNewLessons(Lessons lessons) {

        return "";
    }

    @Override
    public List<Lessons> getAllLessonsByName() {
        return List.of();
    }

    @Override
    public List<Lessons> getAllLessonsByGroup() {
        return List.of();
    }

    @Override
    public String deleteLessons(Lessons name) {
        return "";
    }
}
