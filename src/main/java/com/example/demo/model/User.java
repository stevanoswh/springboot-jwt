package com.example.demo.model;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    private String username;
    private String password;
    private String role;
}
