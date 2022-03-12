package pl.javawwa32.karolproj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.javawwa32.karolproj.dto.UserRequest;
import pl.javawwa32.karolproj.dto.UserResponse;
import pl.javawwa32.karolproj.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/api/user")
    public ResponseEntity<UserResponse> findByEmail(@RequestParam String email){
        final UserResponse user = userService.findResponseByEmail(email);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Example_header", "dummy_value");
        return new ResponseEntity(user, httpHeaders, HttpStatus.ACCEPTED);
    }



    @PostMapping(path = "/api/user")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createClient(@RequestBody UserRequest user){
        userService.save(user);
    }
}
