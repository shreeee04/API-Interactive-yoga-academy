package com.example.artf.Service;

import com.example.artf.Model.User;
import com.example.artf.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getUsersByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public List<User> getUsersByNameLike(String firstName, String lastName) {
        return userRepository.findByLastNameContaining(lastName);
    }
    

    public long countUsersByEmailDomain(String domain) {
        return userRepository.countUsersByEmailDomain(domain);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    

    public void updateUserEmail(String username, String email) {
        userRepository.updateUserEmailByUsername(username, email);
    }

    public void deleteUserByUsername(String username) {
        userRepository.deleteByUsername(username);
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    
}
