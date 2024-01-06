package br.com.apisimplepicpay.infra.adapters.entities;

import br.com.apisimplepicpay.domain.User;
import br.com.apisimplepicpay.domain.enums.UserTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo 'primeiro nome' não pode está em branco.' ")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "O campo 'ultimo nome' não pode está em branco.' ")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "O campo 'documento' não pode está em branco.' ")
    @Column(unique = true)
    private String document;

    @NotBlank(message = "O campo 'email' não pode está em branco.' ")
    private String email;

    @NotBlank(message = "O campo 'senha' não pode está em branco.' ")
    private String password;

    @NotNull(message = "O campo 'saldo' não pode está em branco.' ")
    private BigDecimal balance;

    @NotNull(message = "O campo 'tipo de usuário' não pode está em branco.' ")
    @Column(name = "user_types")
    @Enumerated(EnumType.STRING)
    private UserTypeEnum userType;

    public UserEntity() {
    }

    public UserEntity(User user) {
        id = user.getId();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        document = user.getDocument();
        email = user.getEmail();
        password = user.getPassword();
        balance = user.getBalance();
        userType = user.getUserType();
    }

    public User toUser() {
        return new User(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public UserTypeEnum getUserType() {
        return userType;
    }

    public void setUserType(UserTypeEnum userType) {
        this.userType = userType;
    }
}