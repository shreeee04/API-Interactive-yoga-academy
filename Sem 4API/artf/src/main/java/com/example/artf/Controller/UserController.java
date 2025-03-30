package com.example.artf.Controller;

import com.example.artf.Model.User;
import com.example.artf.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get user by username
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> user = userService.getUserByUsername(username);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.getUserByEmail(email);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get users by first name
    @GetMapping("/first-name/{firstName}")
    public ResponseEntity<List<User>> getUsersByFirstName(@PathVariable String firstName) {
        List<User> users = userService.getUsersByFirstName(firstName);
        return ResponseEntity.ok(users);
    }

    // Find users by name like (firstName and lastName)
    @GetMapping("/search")
    public ResponseEntity<List<User>> getUsersByNameLike(@RequestParam String firstName, @RequestParam String lastName) {
        List<User> users = userService.getUsersByNameLike(firstName, lastName);
        return ResponseEntity.ok(users);
    }

    // Count users by email domain
    @GetMapping("/count-by-email-domain")
    public ResponseEntity<Long> countUsersByEmailDomain(@RequestParam String domain) {
        long count = userService.countUsersByEmailDomain(domain);
        return ResponseEntity.ok(count);
    }

    // Update user email by username
    @PutMapping("/update-email")
    public ResponseEntity<Void> updateUserEmail(@RequestParam String username, @RequestParam String email) {
        userService.updateUserEmail(username, email);
        return ResponseEntity.ok().build();
    }
    // Create a new user
@PostMapping("/create")
public ResponseEntity<User> createUser(@RequestBody User user) {
    User savedUser = userService.createUser(user);
    return ResponseEntity.ok(savedUser);
}


    // Delete user by username
    @DeleteMapping("/delete/{username}")
    public ResponseEntity<Void> deleteUserByUsername(@PathVariable String username) {
        userService.deleteUserByUsername(username);
        return ResponseEntity.ok().build();
    }
    // Get all users
@GetMapping("/all")
public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.getAllUsers();
    return ResponseEntity.ok(users);
}

}
