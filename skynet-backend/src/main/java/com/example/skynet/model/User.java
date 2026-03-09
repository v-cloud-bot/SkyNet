package com.example.skynet.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role; // ADMIN, USER, TRANSPORTER
    private String creation_date;
    private String createAdminById;
}