package pl.javawwa32.karolproj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.javawwa32.karolproj.dto.UserRequest;
import pl.javawwa32.karolproj.dto.UserResponse;
import pl.javawwa32.karolproj.model.User;
import pl.javawwa32.karolproj.repository.UsersRepository;



@Service
public class UserService {

    private final UsersRepository userRepository;
    private final UserMapper mapper;

    @Autowired
    public UserService(UsersRepository userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }


    public void save(UserRequest clientRequest){
        User user = mapper.map(clientRequest);
        userRepository.save(user);
    }



    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public UserResponse findResponseByEmail(String email){
        final User client = findByEmail(email);
        return mapper.map(client);

    }



}
