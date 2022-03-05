package pl.javawwa32.karolproj.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.javawwa32.karolproj.model.AccountType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    private Long userId;

    private String name;

    private String email;

    private String password;

    private String phone;

    private AccountType accountType;
}