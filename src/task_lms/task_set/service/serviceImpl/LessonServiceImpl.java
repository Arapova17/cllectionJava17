package task_lms.task_set.service.serviceImpl;

import task_lms.task_set.database.Database;
import task_lms.task_set.models.Group;
import task_lms.task_set.models.Lessons;
import task_lms.task_set.service.LessonService;

import javax.xml.crypto.Data;
import java.util.Collections;
import java.util.List;

public class LessonServiceImpl implements LessonService {
    @Override
    public String addNewLessons(Lessons lessons) {
        Database.lessons.add(lessons);
        return "Success";
    }

    @Override
    public List<Lessons> getAllLessonsByName(String name) {
        for (Lessons lessons : Database.lessons){
            if (lessons.equals(name)){
                return Database.lessons;
            }
        }
        return null;
    }

    @Override
    public List<Lessons> getAllLessonsByGroup(String groupName) {
       for (Group group : Database.groups){
           if (group.equals(groupName)){
              return Database.lessons;
           }
       }
        return null;
    }

    @Override
    public String deleteLessons(String name) {
        for (Lessons lessons : Database.lessons){
            if (lessons.equals(lessons)){
                Database.lessons.remove(name);
            }
        }
        return "not found";
    }
}
