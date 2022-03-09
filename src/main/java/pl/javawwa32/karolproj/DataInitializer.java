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
                .description("Jest przykładem film à clef, czyli przedstawia prawdziwą historię za fasadą fikcyjnego scenariusza, " +
                        "używając zmienionych nazwisk. Opowiada on o życiu i spuściźnie Charlesa Fostera Kane'a, magnata prasowego...")
                .numberOfCopies(1)
                .avgScore(4.7)
                .movieStatus(MovieStatus.CLASSIC)
                .genre(Genre.ACTION)
                .build();

        var movie2 = Movie.builder()
                .title("Zawrót Głowy")
                .releaseDate(LocalDate.of(2022,10,02))
                .description("James Stewart w roli cierpiącego na lęk wysokości detektywa, " +
                        "wynajętego by śledzić żonę przyjaciela, która ma skłonności samobójcze (Kim Novak)...")
                .numberOfCopies(2)
                .avgScore(3.5)
                .movieStatus(MovieStatus.PREMIERE)
                .genre(Genre.FANTASY)
                .build();

        var movie3 = Movie.builder()
                .title("Ojciec chrzestny")
                .releaseDate(LocalDate.of(1999,10,02))
                .description("Don Vito Corleone (Marlon Brando) jest Ojcem Chrzestnym nowojorskiej rodziny mafijnej. " +
                        "Jest tyranem i szantażystą, a zarazem człowiekiem honoru, sprawującym rządy żelazną ręką. " +
                        "Jego decyzje mają charakter ostateczny i nie ma od nich odwołania...")
                .numberOfCopies(1)
                .avgScore(4.6)
                .movieStatus(MovieStatus.STANDARD)
                .genre(Genre.COMEDY)
                .build();
        var movie4 = Movie.builder()
                .title("District 9")
                .releaseDate(LocalDate.of(2009,10,9))
                .description("Bez precyzyjnego planu jak zorganizować życie uchodźców, ludzie odizolowali ich w dystrykcie 9." +
                        " – zamkniętej dzielnicy Johannesburga. Powołana do jej nadzoru specjalna firma Multi-" +
                        "National United nie dba jednak o godziwe warunki dla przybyszy...")
                .numberOfCopies(8)
                .avgScore(4.5)
                .movieStatus(MovieStatus.STANDARD)
                .genre(Genre.COMEDY)
                .build();

        var movie5 = Movie.builder()
                .title("The Batman")
                .releaseDate(LocalDate.of(2022,3,4))
                .description("The Batman – amerykański fantastycznonaukowy film akcji na podstawie serii komiksów o superbohaterze " +
                        "o tym samym imieniu wydawnictwa DC Comics...")
                .numberOfCopies(5)
                .avgScore(4.9)
                .movieStatus(MovieStatus.PREMIERE)
                .genre(Genre.FANTASY)
                .build();

        var movie6 = Movie.builder()
                .title("Spider-Man: Bez drogi do domu")
                .releaseDate(LocalDate.of(2021,12,17))
                .description("Spider-Man: Bez drogi do domu – amerykański fantastycznonaukowy film akcji " +
                        "na podstawie serii komiksów o superbohaterze o tym samym pseudonimie wydawnictwa Marvel Comics...")
                .numberOfCopies(5)
                .avgScore(4.8)
                .movieStatus(MovieStatus.PREMIERE)
                .genre(Genre.FANTASY)
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
                .score(1.0)
                .text("It's pretty good")
                .movie(movie3)
                .user(user2)
                .build();

        moviesRepository.saveAll(Arrays.asList(movie1, movie2, movie3,movie4,movie5,movie6));
    }
}

