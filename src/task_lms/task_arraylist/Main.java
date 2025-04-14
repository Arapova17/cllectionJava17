package task_lms.task_arraylist;

import task_lms.task_arraylist.models.*;
import task_lms.task_arraylist.service.BookService;
import task_lms.task_arraylist.service.LibraryService;
import task_lms.task_arraylist.service.ReaderService;
import task_lms.task_arraylist.service.serviceImpl.BookServiceImpl;
import task_lms.task_arraylist.service.serviceImpl.LibraryServiceImpl;
import task_lms.task_arraylist.service.serviceImpl.ReaderServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LibraryService libraryService = new LibraryServiceImpl();
        BookService bookService = new BookServiceImpl();
        ReaderService readerService = new ReaderServiceImpl();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    
                    LIBRARY MENU
                    1. Save Library
                    2. Get All Libraries
                    3. Get Library By ID
                    4. Update Library
                    5. Delete Library
                    6. Save Book to Library
                    7. Get All Books in Library
                    8. Get Book By ID
                    9. Delete Book From Library
                    10. Clear All Books From Library
                    11. Save Reader
                    12. Get All Readers
                    13. Get Reader By ID
                    14. Update Reader
                    15. Assign Reader To Library
                    0. Exit
                    --------------------------
                    """);

            System.out.print("Тандоо жасаңыз: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Library ID: ");
                    Long id = scanner.nextLong(); scanner.nextLine();
                    System.out.print("Library Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Library Address: ");
                    String address = scanner.nextLine();

                    List<Library> newLibraries = new ArrayList<>();
                    newLibraries.add(new Library(id, name, address));
                    libraryService.saveLibrary(newLibraries);
                    System.out.println("Library saved!");
                }

                case 2 -> {
                    List<Library> libraries = libraryService.getAllLibraries();
                    libraries.forEach(System.out::println);
                }

                case 3 -> {
                    System.out.print("Library ID: ");
                    Long id = scanner.nextLong();
                    Library lib = libraryService.getLibraryById(id);
                    System.out.println(lib != null ? lib : "Library not found!");
                }

                case 4 -> {
                    System.out.print("Library ID: ");
                    Long id = scanner.nextLong(); scanner.nextLine();
                    System.out.print("New Name: ");
                    String name = scanner.nextLine();
                    System.out.print("New Address: ");
                    String address = scanner.nextLine();

                    Library updated = libraryService.updateLibrary(id, new Library(id, name, address));
                    System.out.println(updated != null ? "Updated: " + updated : "Library not found!");
                }

                case 5 -> {
                    System.out.print("Library ID: ");
                    Long id = scanner.nextLong();
                    System.out.println(libraryService.deleteLibrary(id));
                }

                case 6 -> {
                    System.out.print("Library ID: ");
                    Long libId = scanner.nextLong(); scanner.nextLine();
                    System.out.print("Book ID: ");
                    Long bookId = scanner.nextLong(); scanner.nextLine();
                    System.out.print("Book Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Genre (FICTION, DRAMA, etc): ");
                    Genre genre = Genre.valueOf(scanner.nextLine().toUpperCase());

                    Book book = new Book(bookId, name, author, genre);
                    bookService.saveBook(libId, book);
                    System.out.println("Book saved to library!");
                }

                case 7 -> {
                    System.out.print("Library ID: ");
                    Long libId = scanner.nextLong();
                    List<Book> books = bookService.getAllBooks(libId);
                    if (books != null) books.forEach(System.out::println);
                    else System.out.println("Library not found.");
                }

                case 8 -> {
                    System.out.print("Library ID: ");
                    Long libId = scanner.nextLong();
                    System.out.print("Book ID: ");
                    Long bookId = scanner.nextLong();
                    Book book = bookService.getBookById(libId, bookId);
                    System.out.println(book != null ? book : "Book not found.");
                }

                case 9 -> {
                    System.out.print("Library ID: ");
                    Long libId = scanner.nextLong();
                    System.out.print("Book ID: ");
                    Long bookId = scanner.nextLong();
                    System.out.println(bookService.deleteBook(libId, bookId));
                }

                case 10 -> {
                    System.out.print("Library ID: ");
                    Long libId = scanner.nextLong();
                    bookService.clearBooksByLibraryId(libId);
                    System.out.println("All books cleared from library.");
                }

                case 11 -> {
                    System.out.print("Reader ID: ");
                    Long id = scanner.nextLong(); scanner.nextLine();
                    System.out.print("Full Name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Gender (MALE/FEMALE): ");
                    Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());

                    Reader reader = new Reader(id, fullName, email, phone, gender);
                    readerService.saveReader(reader);
                    System.out.println("Reader saved!");
                }

                case 12 -> {
                    List<Reader> readers = readerService.getAllReaders();
                    readers.forEach(System.out::println);
                }

                case 13 -> {
                    System.out.print("Reader ID: ");
                    Long id = scanner.nextLong();
                    Reader reader = readerService.getReaderById(id);
                    System.out.println(reader != null ? reader : "Reader not found.");
                }

                case 14 -> {
                    System.out.print("Reader ID: ");
                    Long id = scanner.nextLong(); scanner.nextLine();
                    System.out.print("Full Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Gender (MALE/FEMALE): ");
                    Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());

                    Reader updatedReader = new Reader(id, name, email, phone, gender);
                    Reader result = readerService.updateReader(id, updatedReader);
                    System.out.println(result != null ? "Reader updated!" : "❌ Reader not found.");
                }

                case 15 -> {
                    System.out.print("Reader ID: ");
                    Long readerId = scanner.nextLong();
                    System.out.print("Library ID: ");
                    Long libraryId = scanner.nextLong();
                    readerService.assignReaderToLibrary(readerId, libraryId);
                    System.out.println("Reader assigned to library.");
                }

                case 0 -> {
                    System.out.println("Программа жабылды.");
                    return;
                }

                default -> System.out.println("Туура эмес тандоо!");
            }
        }
    }
}
