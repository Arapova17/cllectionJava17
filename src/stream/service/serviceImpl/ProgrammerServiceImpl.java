package stream.service.serviceImpl;

import linkedlist.service.PackageService;
import stream.dao.ProgrammerDao;
import stream.dao.daoImpl.ProgrammerDaoImpl;
import stream.models.Programmer;
import stream.service.ProgrammerService;

import java.util.List;

public class ProgrammerServiceImpl implements ProgrammerService {
    ProgrammerDao programmerDao = new ProgrammerDaoImpl();
    @Override
    public void addProgrammer(Programmer programmer) {
        programmerDao.addProgrammer(programmer);
    }

    @Override
    public List<Programmer> getAllProgrammer() {
        return programmerDao.getAllProgrammer();
    }

    @Override
    public List<Programmer> getAllJavaProgrammer() {
        return programmerDao.getAllJavaProgrammer();
    }

    @Override
    public Programmer getById(Long id) {
        return programmerDao.getById(id);
    }

    @Override
    public int countProgrammers() {
        return programmerDao.countProgrammers();
    }

    @Override
    public List<Programmer> sortProgrammerBySalary() {
        return programmerDao.sortProgrammerBySalary();
    }

    @Override
    public List<Programmer> skip2Programmer() {
        return programmerDao.skip2Programmer();
    }

    @Override
    public Programmer getMaxSalaryProgrammer() {
        return programmerDao.getMaxSalaryProgrammer();
    }
}
