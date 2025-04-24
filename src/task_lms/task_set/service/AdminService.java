package task_lms.task_set.service;

import task_lms.task_set.models.Admin;

import java.util.Map;

public interface AdminService {
    Map<String, String> registerAdmin (Admin admin);
}
