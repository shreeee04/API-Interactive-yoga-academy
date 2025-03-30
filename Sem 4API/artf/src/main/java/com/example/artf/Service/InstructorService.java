package com.example.artf.Service;

import com.example.artf.Model.Instructor;
import com.example.artf.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    // Create an Instructor
    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    // Get Instructor by ID
    public Optional<Instructor> getInstructorById(Long id) {
        return instructorRepository.findById(id);
    }

    // Get All Instructors (with Pagination & Sorting)
    public Page<Instructor> getAllInstructors(Pageable pageable) {
        return instructorRepository.findAll(pageable);
    }

    // Update Instructor
    public Instructor updateInstructor(Long id, Instructor instructorDetails) {
        Optional<Instructor> instructorOptional = instructorRepository.findById(id);
        if (instructorOptional.isPresent()) {
            Instructor instructor = instructorOptional.get();
            instructor.setFirstName(instructorDetails.getFirstName());
            instructor.setLastName(instructorDetails.getLastName());
            instructor.setEmail(instructorDetails.getEmail());
            instructor.setPhoneNumber(instructorDetails.getPhoneNumber());
            instructor.setBio(instructorDetails.getBio());
            return instructorRepository.save(instructor);
        }
        return null;
    }

    // Delete Instructor
    public void deleteInstructor(Long id) {
        instructorRepository.deleteById(id);
    }

    // Get Instructor by Email
    public Optional<Instructor> getInstructorByEmail(String email) {
        return instructorRepository.findByEmail(email);
    }

    // Search Instructors by Name (with Pagination & Sorting)
    public Page<Instructor> searchInstructorsByName(String firstName, String lastName, Pageable pageable) {
        return instructorRepository.findByFirstNameContainingOrLastNameContaining(firstName, lastName, pageable);
    }
}
