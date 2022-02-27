package pl.javawwa32.karolproj.dto;

import lombok.Data;
import pl.javawwa32.karolproj.model.AccountType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Data
public class UserDto {


    private Long userId;

    @NotNull
    @Size(min = 5, max = 20, message = "Title must be between 5 to 20 characters long")
    private String name;

    @Email(message = "E-mail address format wrong")
    private String email;

    @Pattern(regexp = "([0-9]{3}\\s[0-9]{3}\\s[0-9]{3})|([0-9]{9})", message = "Allowed phone number formats: xxx xxx xxx or xxxxxxxxx")
    private String phone;

    @NotNull(message = "AccountType must be given")
    private AccountType accountType;
}
