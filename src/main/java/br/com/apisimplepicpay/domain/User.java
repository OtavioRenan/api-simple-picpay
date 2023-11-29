package br.com.apisimplepicpay.domain;

import br.com.apisimplepicpay.domain.dtos.UserDTO;
import br.com.apisimplepicpay.domain.enums.UserTypeEnum;
import br.com.apisimplepicpay.infra.adapters.entities.UserEntity;

import java.math.BigDecimal;

public class User {
    private Long id;

    private String firstName;

    private String lastName;

    private String document;

    private String email;

    private String password;

    private BigDecimal balance;

    private UserTypeEnum userType;

    public User(UserEntity entity) {
        id = entity.getId();
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        document = entity.getDocument();
        email = entity.getEmail();
        password = entity.getPassword();
        balance = entity.getBalance();
        userType = entity.getUserType();
    }

    public User(UserDTO dto) {
        id = dto.getId();
        firstName = dto.getFirstName();
        lastName = dto.getLastName();
        document = dto.getDocument();
        email = dto.getEmail();
        password = dto.getPassword();
        balance = dto.getBalance();
        userType = dto.getUserType();
    }

    public UserDTO toUserDTO() {
        return new UserDTO(this);
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
