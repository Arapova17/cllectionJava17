package stream.service;

import stream.models.Programmer;

import java.util.List;

public interface ProgrammerService {
    void addProgrammer(Programmer programmer);
    List<Programmer> getAllProgrammer();
    List<Programmer> getAllJavaProgrammer();
    Programmer getById(Long id);
    int countProgrammers();
    List<Programmer> sortProgrammerBySalary();
    List<Programmer> skip2Programmer();
    Programmer getMaxSalaryProgrammer();
}
