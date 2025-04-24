package task_lms.task_set.service;

import task_lms.task_set.models.Students;

import java.util.List;

public interface StudentsService {
    String addNewStudent (Students students);
    String updateStudent (String email, String password, Students newStudents);
    Students getStudentName (String firstName);
    List<Students> getAllStudentsByGroupName ();
    List<Students> getAllStudentsByLessonsName ();
    String deleteStudent (String firstName);
}
