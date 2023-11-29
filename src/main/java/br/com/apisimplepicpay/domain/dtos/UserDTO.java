package br.com.apisimplepicpay.domain.dtos;

import br.com.apisimplepicpay.domain.User;
import br.com.apisimplepicpay.domain.enums.UserTypeEnum;

import java.math.BigDecimal;

public class UserDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String document;

    private String email;

    private String password;

    private BigDecimal balance;

    private UserTypeEnum userType;

    public UserDTO() {
    }

    public UserDTO(User user) {
        id = user.getId();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        document = user.getDocument();
        email = user.getEmail();
        password = user.getPassword();
        balance = user.getBalance();
        userType = user.getUserType();
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
