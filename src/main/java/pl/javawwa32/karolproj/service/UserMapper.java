package pl.javawwa32.karolproj.service;

import org.springframework.stereotype.Component;
import pl.javawwa32.karolproj.dto.UserRequest;
import pl.javawwa32.karolproj.dto.UserResponse;
import pl.javawwa32.karolproj.model.User;

import java.util.Optional;

@Component
public class UserMapper {


    public UserResponse map(User user){
        final UserResponse userResponse = UserResponse
                .builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .phone(user.getPhone())
                .accountType(user.getAccountType())
                .build();
        return userResponse;
    }


    public User map(UserRequest userRequest){
        final User client = User
                .builder()
                .name(userRequest.getName())
                .phone(userRequest.getPhone())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .accountType(userRequest.getAccountType())
                .build();

        return client;
    }
}
