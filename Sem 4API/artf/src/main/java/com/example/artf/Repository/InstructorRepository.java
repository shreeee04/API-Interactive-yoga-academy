package com.example.artf.Repository;

import com.example.artf.Model.Instructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    Optional<Instructor> findByEmail(String email);

    Page<Instructor> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName, Pageable pageable);
}
