package task_lms.task_arraylist.service.serviceImpl;

import task_lms.task_arraylist.database.Database;
import task_lms.task_arraylist.models.Library;
import task_lms.task_arraylist.service.LibraryService;

import java.util.List;

public class LibraryServiceImpl implements LibraryService {
    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        Database.libraries.addAll(libraries);
        return libraries;
    }

    @Override
    public List<Library> getAllLibraries() {
        return Database.libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        return Database.libraries.stream()
                .filter(library -> library.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Library updateLibrary(Long id, Library updatelibrary) {
        for (Library library : Database.libraries) {
            if (library.id().equals(id)) {
                library.setName(updatelibrary.name());
                library.setAddress(updatelibrary.address());
                return library;
            }
        }
        return null;
    }

    @Override
    public String deleteLibrary(Long id) {
        boolean removed = Database.libraries.removeIf(library -> library.id().equals(id));
        return removed ? "Library successfully deleted." : "Library not found.";
    }
}
