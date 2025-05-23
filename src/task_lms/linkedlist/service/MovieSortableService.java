package task_lms.linkedlist.service;

public interface MovieSortableService {
    void sortMovieByName(String ascOrDesc);
    void sortByYear(String ascOrDesc);
    void sortByProducer(String nameOrLastName);
}
