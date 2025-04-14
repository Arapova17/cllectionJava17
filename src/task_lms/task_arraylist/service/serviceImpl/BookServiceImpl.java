package task_lms.task_arraylist.service.serviceImpl;

import task_lms.task_arraylist.database.Database;
import task_lms.task_arraylist.models.Book;
import task_lms.task_arraylist.models.Library;
import task_lms.task_arraylist.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public Book saveBook(Long libraryId, Book book) {
        for (Library library : Database.libraries) {
            if (library.id().equals(libraryId)) {
                library.books().add(book);
                Database.books.add(book);
                return book;
            }
        }
            return null;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        for (Library library : Database.libraries) {
            if (library.id().equals(libraryId)) {
                return library.books();
            }
        }
        return null;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        for (Library library : Database.libraries) {
            if (library.id().equals(libraryId)) {
                return library.books().stream()
                        .filter(book -> book.id().equals(bookId))
                        .findFirst()
                        .orElse(null);
            }
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for (Library library : Database.libraries) {
            if (library.id().equals(libraryId)) {
                boolean removed = library.books().removeIf(book -> book.id().equals(bookId));
                Database.books.removeIf(book -> book.id().equals(bookId));
                return removed ? "Book deleted successfully." : "Book not found.";
            }
        }
        return "Library not found.";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        for (Library library : Database.libraries) {
            if (library.id().equals(libraryId)) {
                library.books().clear();
                break;
            }
        }
    }
}
