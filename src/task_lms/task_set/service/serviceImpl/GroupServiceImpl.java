package task_lms.task_set.service.serviceImpl;

import task_lms.task_set.models.Group;
import task_lms.task_set.service.GroupService;

import java.util.List;

public class GroupServiceImpl implements GroupService {
    @Override
    public String addNewGroup(Group group) {

        return "";
    }

    @Override
    public Group groupByName(String firstName) {
        return null;
    }

    @Override
    public String updateGroupName(String firstName, Group newName) {
        return "";
    }

    @Override
    public List<Group> getAllGroup() {
        return List.of();
    }

    @Override
    public String deleteGroup(Group name) {
        return "";
    }
}
