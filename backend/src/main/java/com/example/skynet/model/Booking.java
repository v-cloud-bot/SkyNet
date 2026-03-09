package com.example.skynet.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bookings")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String materialType;
    private String pickupLocation;
    private String dropLocation;
    private String status; // PENDING, ASSIGNED, COMPLETED
    
    private String paymentMethod; // QR or CASH
    private boolean isPaid = false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "transporter_id")
    private User transporter;
}