//package pl.javawwa32.karolproj.service;
//
//import org.junit.jupiter.api.Test;
//import pl.javawwa32.karolproj.model.AccountType;
//import pl.javawwa32.karolproj.model.User;
//import pl.javawwa32.karolproj.repository.UsersRepository;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class UserStatusChangerTest {
//
//    @Test
//    void changes_user_status(){
//        var userStatusChangerService = new UserStatusChanger();
//
//        static class UserRepositoryListTestImpl implements UsersRepository{
//
//
//
//    List<User> getTestUsers(){
//        var user1 = User.builder()
//                .email("user1@o2.pl")
//                .phone("111000000")
//                .password("password1")
//                .accountType(AccountType.GOLD)
//                .build();
//
//        var user2 = User.builder()
//                .email("user2@o2.pl")
//                .phone("222000000")
//                .password("password2")
//                .accountType(AccountType.PLATINUM)
//                .build();
//
//        var user3 = User.builder()
//                .email("user3@o2.pl")
//                .phone("333000000")
//                .password("password3")
//                .accountType(AccountType.SILVER)
//                .build();
//
//
//    }
//
//}