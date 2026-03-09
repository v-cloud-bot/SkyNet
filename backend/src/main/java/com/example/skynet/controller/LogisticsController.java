package com.example.skynet.controller;

import com.example.skynet.model.Booking;
import com.example.skynet.model.User;
import com.example.skynet.repository.BookingRepository;
import com.example.skynet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173") // Connects to your React Vite port
public class LogisticsController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    // 1. User/Transporter Signup
    @PostMapping("/signup")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // 2. Create a new Booking (Location to Location)
    @PostMapping("/book")
    public Booking createBooking(@RequestBody Booking booking) {
        booking.setStatus("PENDING"); // Default status for new material
        return bookingRepository.save(booking);
    }

    // 3. Admin: Find all Transporters
    @GetMapping("/transporters")
    public List<User> getTransporters() {
        return userRepository.findByRole("TRANSPORTER");
    }
}