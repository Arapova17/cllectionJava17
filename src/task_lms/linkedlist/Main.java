package task_lms.linkedlist;

import task_lms.linkedlist.enums.Genre;
import task_lms.linkedlist.models.Actor;
import task_lms.linkedlist.models.Movie;
import task_lms.linkedlist.models.Producer;
import task_lms.linkedlist.service.serviceImpl.MovieFindableServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Producer классынын обьектиси
        Producer producer1 = new Producer("Christopher", "Nolan");
        Producer producer2 = new Producer("James", "Cameron");

        //Actor классынын обьектиси
        Actor actor1 = new Actor("Leonardo DiCaprio", "Cobb");
        Actor actor2 = new Actor("Joseph Gordon-Levitt", "Arthur");
        Actor actor3 = new Actor("Kate Winslet", "Rose");
        Actor actor4 = new Actor("Sam Worthington", "Jake Sully");

        //MovieFindableServiceImpl классынын обьектиси
        MovieFindableServiceImpl service = new MovieFindableServiceImpl(List.of(
                new Movie("Inception", LocalDate.of(2010, 7, 16),
                        Genre.SCI_FI, producer1,  List.of(actor1, actor2)),
                new Movie("Titanic", LocalDate.of(1997, 12, 19),
                        Genre.ROMANCE, producer2, List.of(actor1, actor3)),
                new Movie("Avatar", LocalDate.of(2009, 12, 18),
                        Genre.ACTION, producer2, List.of(actor4))));

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    1. Бардык фильмдерди корсотуу
                    2. Фильмди аты же атынын бир бөлүгү менен издөө
                    3. Актёрдун аты боюнча фильм издөө
                    4. Фильмди чыгарылган жылы боюнча издөө
                    5. Продюсердин аты боюнча фильм издөө
                    6. Жанр боюнча фильм издөө
                    7. Актёр ойногон ролу боюнча фильм издөө
                    8. Фильмдерди аты боюнча иреттөө (өсүү/төмөндөө тартибинде)
                    9. Фильмдерди жылы боюнча иреттөө (өсүү/төмөндөө тартибинде)
                    10. Фильмдерди продюсердин аты же фамилиясы боюнча иреттөө
                    0. Чыгуу
                    """);
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> service.getAllMovies().forEach(System.out::println);
                case 2 -> {
                    System.out.print(" Фильмди аты же атынын бир бөлүгү: ");
                    System.out.println(service.findMovieByFullNameOrPartName(sc.nextLine()));
                }
                case 3 -> {
                    System.out.print("Актёрдун аты: ");
                    System.out.println(service.findMovieByActorName(sc.nextLine()));
                }
                case 4 -> {
                    System.out.print("Фильмдин жылы: ");
                    LocalDate date = LocalDate.parse(sc.nextLine());
                    System.out.println(service.findMovieByYear(date));
                }
                case 5 -> {
                    System.out.print("Продюсердин толук аты: ");
                    System.out.println(service.findMovieByProducer(sc.nextLine()));
                }
                case 6 -> {
                    System.out.print("Жанр: ");
                    System.out.println(service.findMovieByGenre(Genre.valueOf(sc.nextLine().toUpperCase())));
                }
                case 7 -> {
                    System.out.print("Актёрдун ролу : ");
                    System.out.println(service.findMovieByRole(sc.nextLine()));
                }
                case 8 -> {
                    System.out.print("Фильмдерди атынан сорттоо (asc же desc): ");
                    service.sortMovieByName(sc.nextLine());
                    service.getAllMovies().forEach(System.out::println);
                }
                case 9 -> {
                    System.out.print("Фильмдерди жылы боюнча сорттоо (asc же desc): ");
                    service.sortByYear(sc.nextLine());
                    service.getAllMovies().forEach(System.out::println);
                }
                case 10 -> {
                    System.out.print("Продюсердин аты же фамилиясы : ");
                    service.sortByProducer(sc.nextLine());
                    service.getAllMovies().forEach(System.out::println);
                }
                // Программаны токтотуу
                case 0 -> System.exit(0);
                default -> System.out.println("Туура эмес тандоо!");
            }
        }
    }
}
