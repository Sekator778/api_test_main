package com.example.api.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by dn070578noi on 30.04.23.
 */
@Getter
@Setter
@Entity
@Table(name = "users")
@ToString
public class User {

    @Id
    private Long id;
    @Column(name = "user_name")
    private String userName;
    private String email;

    public User() {
    }

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public User(Long id, String userName, String email) {
        this(userName, email);
        this.id = id;
    }
}
