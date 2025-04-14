package task_lms.linkedlist.service.serviceImpl;

import task_lms.linkedlist.enums.Genre;
import task_lms.linkedlist.models.Actor;
import task_lms.linkedlist.models.Movie;
import task_lms.linkedlist.service.MovieFindableService;
import task_lms.linkedlist.service.MovieSortableService;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MovieFindableServiceImpl implements MovieFindableService, MovieSortableService{
    private List<Movie> movies; // Фильмдердин тизмеси

    // Конструктор: movies тизмесин инициализация кылат
    public MovieFindableServiceImpl (List<Movie> movies) {
        this.movies = movies;
    }

    // Бардык фильмдерди кайтарат
    @Override
    public List<Movie> getAllMovies() {
        return movies;
    }

    // Фильмди толук аты же анын бир бөлүгү менен издейт
    @Override
    public Movie findMovieByFullNameOrPartName(String name) {
        for (Movie movie : movies) {
            if (movie.name().toLowerCase().contains(name.toLowerCase())) {
                return movie;
            }
        }
        return null;
    }

    // Актёрдун аты менен фильм издейт
    @Override
    public Movie findMovieByActorName(String actorName) {
        for (Movie movie : movies) {
            for (Actor actor : movie.actors()) {
                if (actor.actorFullName().equalsIgnoreCase(actorName)) {
                    return movie;
                }
            }
        }
        return null;
    }

    // Фильмди чыгарылган жылы менен издейт
    @Override
    public Movie findMovieByYear(LocalDate year) {
        for (Movie movie : movies) {
            if (movie.year().equals(year)) {
                return movie;
            }
        }
        return null;
    }

    // Продюсердин аты-жөнү боюнча фильм издейт
    @Override
    public Movie findMovieByProducer(String producerFullName) {
        for (Movie movie : movies) {
            String fullName = movie.producer().getFullName();
            if (fullName.equalsIgnoreCase(producerFullName)) {
                return movie;
            }
        }
        return null;
    }

    // Жанр боюнча фильм издейт
    @Override
    public Movie findMovieByGenre(Genre genre) {
        for (Movie movie : movies) {
            if (movie.genre() == genre) {
                return movie;
            }
        }
        return null;
    }

    // Ролу менен фильм издейт
    @Override
    public Movie findMovieByRole(String role) {
        for (Movie movie : movies) {
            for (Actor actor : movie.actors()) {
                if (actor.role().equalsIgnoreCase(role)) {
                    return movie;
                }
            }
        }
        return null;
    }

    // Фильмдерди аты боюнча сорттоо (asc же desc)
    @Override
    public void sortMovieByName(String ascOrDesc) {
        movies.sort(Comparator.comparing(Movie::name));
        if (ascOrDesc.equalsIgnoreCase("desc")) {
            Collections.reverse(movies);
        }
    }

    // Фильмдерди чыгарылган жылы боюнча сорттоо
    @Override
    public void sortByYear(String ascOrDesc) {
        movies.sort(Comparator.comparing(Movie::year));
        if (ascOrDesc.equalsIgnoreCase("desc")) {
            Collections.reverse(movies);
        }
    }

    // Фильмдерди продюсердин аты же фамилиясы боюнча сорттоо
    @Override
    public void sortByProducer(String nameOrLastName) {
        if (nameOrLastName.equalsIgnoreCase("name")) {
            // Продюсердин аты боюнча сорттоо
            movies.sort(Comparator.comparing(m -> m.producer().firstName()));
        } else {
            // Продюсердин фамилиясы боюнча сорттоо
            movies.sort(Comparator.comparing(m -> m.producer().lastName()));
        }
    }
}
