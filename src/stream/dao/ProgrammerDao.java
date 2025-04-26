package stream.dao;

import stream.models.Programmer;
import task_lms.task_map.models.Product;

import java.util.EventListenerProxy;
import java.util.List;

public interface ProgrammerDao {
    void addProgrammer(Programmer programmer);
    List<Programmer> getAllProgrammer();
    List<Programmer> getAllJavaProgrammer();
    Programmer getById(Long id);
    int countProgrammers();
    List<Programmer> sortProgrammerBySalary();
    List<Programmer> skip2Programmer();
    Programmer getMaxSalaryProgrammer();
}
