package pl.javawwa32.karolproj.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.javawwa32.karolproj.model.AccountType;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {


    private Long userId;

    private String name;

    private String email;

    private String password;

    private String phone;

    private AccountType accountType;
}
