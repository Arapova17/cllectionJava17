package task_lms.task_arraylist.service;

import task_lms.task_arraylist.models.Library;

import java.util.List;

public interface LibraryService {
    List<Library> saveLibrary(List<Library> libraries);
    List<Library> getAllLibraries();
    Library getLibraryById(Long id);
    Library updateLibrary(Long id, Library library);
    String deleteLibrary(Long id);
}
