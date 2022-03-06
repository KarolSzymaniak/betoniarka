package pl.javawwa32.karolproj;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.javawwa32.karolproj.model.*;
import pl.javawwa32.karolproj.repository.MoviesRepository;
import pl.javawwa32.karolproj.repository.UsersRepository;

import java.time.LocalDate;
import java.util.Arrays;

@Component
@RequiredArgsConstructor(onConstructor_ ={@Autowired})
public class DataInitializer implements CommandLineRunner {

    private final UsersRepository usersRepository;
    private final MoviesRepository moviesRepository;

    @Override
    public void run(final String... args) throws Exception {
        initializeData();
    }

    private void initializeData(){

        var user1 = User.builder()
                .email("user1@o2.pl")
                .phone("111000000")
                .password("password1")
                .accountType(AccountType.GOLD)
                .build();

        var user2 = User.builder()
                .email("user2@o2.pl")
                .phone("222000000")
                .password("password2")
                .accountType(AccountType.PLATINUM)
                .build();

        var user3 = User.builder()
                .email("user3@o2.pl")
                .phone("333000000")
                .password("password3")
                .accountType(AccountType.SILVER)
                .build();

        usersRepository.saveAll(Arrays.asList(user1, user2, user3));

        var movie1 = Movie.builder()
                .title("Obywatel Kane")
                .releaseDate(LocalDate.of(2020,10,02))
                .numberOfCopies(1)
                .avgScore(5.0)
                .movieStatus(MovieStatus.CLASSIC)
                .genre(Genre.ACTION)
                .build();

        var movie2 = Movie.builder()
                .title("Zawrót Głowy")
                .releaseDate(LocalDate.of(2022,10,02))
                .numberOfCopies(2)
                .avgScore(3.0)
                .movieStatus(MovieStatus.PREMIERE)
                .genre(Genre.FANTASY)
                .build();

        var movie3 = Movie.builder()
                .title("Ojciec chrzestny")
                .releaseDate(LocalDate.of(1999,10,02))
                .numberOfCopies(1)
                .avgScore(4.0)
                .movieStatus(MovieStatus.STANDARD)
                .genre(Genre.COMEDY)
                .build();

        var copy1 = MovieCopy.builder()
                .movie(movie1)
                .order(null)
                .build();
        var copy2 = MovieCopy.builder()
                .movie(movie2)
                .order(null)
                .build();
        var copy3 = MovieCopy.builder()
                .movie(movie2)
                .order(null)
                .build();
        var copy4 = MovieCopy.builder()
                .movie(movie3)
                .order(null)
                .build();

        var rating1 = Rating.builder()
                .score(5.0)
                .text("It's pretty good")
                .movie(movie1)
                .user(user1)
                .build();
        var rating2 = Rating.builder()
                .score(3.0)
                .text("It's pretty good")
                .movie(movie2)
                .user(user2)
                .build();
        var rating3 = Rating.builder()
                .score(6.0)
                .text("It's pretty good")
                .movie(movie3)
                .user(user2)
                .build();

        moviesRepository.saveAll(Arrays.asList(movie1, movie2, movie3));
    }
}
