package pl.javawwa32.karolproj.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    public User(String name, String email, String phone, AccountType accountType) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.accountType = accountType;
    }
}
