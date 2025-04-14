package task_lms.task_arraylist.database;

import task_lms.task_arraylist.models.Book;
import task_lms.task_arraylist.models.Library;
import task_lms.task_arraylist.models.Reader;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Library> libraries = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();
    public static List<Reader> readers = new ArrayList<>();
}
