package task_lms.task_arraylist.service.serviceImpl;

import task_lms.task_arraylist.database.Database;
import task_lms.task_arraylist.models.Library;
import task_lms.task_arraylist.models.Reader;
import task_lms.task_arraylist.service.ReaderService;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public void saveReader(Reader reader) {
        Database.readers.add(reader);
    }

    @Override
    public List<Reader> getAllReaders() {
        return Database.readers;
    }

    @Override
    public Reader getReaderById(Long id) {
        return Database.readers.stream()
                .filter(reader -> reader.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Reader updateReader(Long id, Reader updateReader) {
        for (Reader reader : Database.readers) {
            if (reader.id().equals(id)) {
                reader.setFullName(updateReader.fullName());
                reader.setEmail(updateReader.email());
                reader.setPhoneNumber(updateReader.phoneNumber());
                reader.setGender(updateReader.gender());
                return reader;
            }
        }
        return null;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        Reader reader = getReaderById(readerId);
        for (Library library : Database.libraries) {
            if (library.id().equals(libraryId)) {
                library.readers().add(reader);
                break;
            }
        }
    }
}
