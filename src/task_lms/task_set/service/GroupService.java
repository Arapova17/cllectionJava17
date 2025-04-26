package task_lms.task_set.service;

import task_lms.task_set.models.Group;

import java.util.List;

public interface GroupService {
    String addGroup (Group group);
    Group groupByName (String firstName);
    String updateGroupName (String firstName, Group newName);
    List<Group> getAllGroup ();
    String deleteGroup (String nameDelete);
}
