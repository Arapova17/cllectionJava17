package stream.dao.daoImpl;

import stream.dao.ProgrammerDao;
import stream.database.Database;
import stream.enums.Language;
import stream.models.Programmer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProgrammerDaoImpl implements ProgrammerDao {
    @Override
    public void addProgrammer(Programmer programmer) {
        Database.programmers.add(programmer);
    }

    @Override
    public List<Programmer> getAllProgrammer() {
        return Database.programmers;
    }

    @Override
    public List<Programmer> getAllJavaProgrammer() {
        return Database.programmers.stream()
                .filter(programmer -> programmer.language() == Language.JAVA)
                .collect(Collectors.toList());

    }

    @Override
    public Programmer getById(Long id) {
        return Database.programmers.stream()
                .filter(programmer -> programmer.id().equals(id))
                .findFirst().get();
    }

    @Override
    public int countProgrammers() {
        return (int) Database.programmers.stream().count();
    }

    @Override
    public List<Programmer> sortProgrammerBySalary() {
        return Database.programmers.stream()
                .sorted(Comparator.comparingDouble(Programmer::salary).reversed())
                .collect(Collectors.toList());

    }

    @Override
    public List<Programmer> skip2Programmer() {
        return Database.programmers.stream()
                .skip(2)
                .toList();
    }

    @Override
    public Programmer getMaxSalaryProgrammer() {
        return Database.programmers.stream()
                .max(Comparator.comparingDouble(Programmer::salary))
                .get();
    }
}
