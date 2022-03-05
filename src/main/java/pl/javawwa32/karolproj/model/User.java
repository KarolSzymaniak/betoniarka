package pl.javawwa32.karolproj.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)

    @Column(name = "user_id")
    private Long userId;

    @Column(name= "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password", unique = true)
    private String password;


    @Column(name = "phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountType accountType;

    public User(String name, String email, String phone,String password, AccountType accountType) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.accountType = accountType;
    }
}
