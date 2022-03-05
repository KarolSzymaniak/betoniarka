package pl.javawwa32.karolproj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.javawwa32.karolproj.model.AccountType;
import pl.javawwa32.karolproj.model.Genre;
import pl.javawwa32.karolproj.model.Movie;
import pl.javawwa32.karolproj.model.User;
import pl.javawwa32.karolproj.repository.UsersRepository;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class StartDataTest {

    private UsersRepository userRepository;

    @Autowired
    public StartDataTest(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    //żeby możliwe było uruchomienie w trakcie startu aplikacji/ kiedy app będzie gotowa, odpali się metoda add user
    @EventListener(ApplicationReadyEvent.class)
    public void addUser() {
        User user1 = new User("Marian", "marian@wp.pl", "777777777", "1238", AccountType.STANDARD);
        User user2 = new User("Andrzej", "andrzej@wp.pl", "333333333", "1235", AccountType.GOLD);
        User user3 = new User("Wiesiek", "wiesio@wp.pl", "555555555", "1230", AccountType.PLATINUM);

    }

}