package com.example.artf.Repository;
import com.example.artf.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    List<User> findByFirstName(String firstName);
    List<User> findByLastNameContaining(String lastName); // Name search

    @Query("SELECT COUNT(u) FROM User u WHERE u.email LIKE %?1")
    long countUsersByEmailDomain(String domain);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.email = ?2 WHERE u.username = ?1")
    void updateUserEmailByUsername(String username, String email);

    @Transactional
    void deleteByUsername(String username);
}
