package task_lms.task_set.service.serviceImpl;

import task_lms.task_set.database.Database;
import task_lms.task_set.models.Group;
import task_lms.task_set.service.GroupService;

import java.util.List;

public class GroupServiceImpl implements GroupService {
    @Override
    public String addGroup(Group group) {
        Database.groups.add(group);
        return "Success";
    }

    @Override
    public Group groupByName(String firstName) {
        for (Group group : Database.groups){
            if (group.groupName().equalsIgnoreCase(firstName)){
                return group;
            }
        }
        return null;
    }

    @Override
    public String updateGroupName(String firstName, Group newName) {
        for (Group group : Database.groups){
            if (group.groupName().equalsIgnoreCase(firstName)){
                group.setGroupName(newName.groupName());
                return "Success";
            }
        }
        return "not found";
    }

    @Override
    public List<Group> getAllGroup() {
        return Database.groups;
    }

    @Override
    public String deleteGroup(String nameDelete) {
        for (Group group : Database.groups){
            if (group.groupName().equalsIgnoreCase(nameDelete)){
                Database.groups.remove(group);
                return "Success";
            }
        }
        return "not found";
    }
}
