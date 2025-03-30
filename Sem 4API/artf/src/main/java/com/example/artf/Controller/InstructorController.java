package com.example.artf.Controller;

import com.example.artf.Model.Instructor;
import com.example.artf.Service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    // Create Instructor
    @PostMapping
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
        Instructor savedInstructor = instructorService.createInstructor(instructor);
        return new ResponseEntity<>(savedInstructor, HttpStatus.CREATED);
    }

    // Get Instructor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Long id) {
        Optional<Instructor> instructor = instructorService.getInstructorById(id);
        return instructor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get All Instructors with Paging & Sorting
    @GetMapping
    public ResponseEntity<Page<Instructor>> getAllInstructors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        
        return ResponseEntity.ok(instructorService.getAllInstructors(pageable));
    }

    // Update Instructor
    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Long id, @RequestBody Instructor instructorDetails) {
        Instructor updatedInstructor = instructorService.updateInstructor(id, instructorDetails);
        return updatedInstructor != null ? ResponseEntity.ok(updatedInstructor) : ResponseEntity.notFound().build();
    }

    // Delete Instructor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
        return ResponseEntity.noContent().build();
    }

    // Get Instructor by Email
    @GetMapping("/email/{email}")
    public ResponseEntity<Instructor> getInstructorByEmail(@PathVariable String email) {
        Optional<Instructor> instructor = instructorService.getInstructorByEmail(email);
        return instructor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Search Instructors by Name with Paging & Sorting
    @GetMapping("/search")
    public ResponseEntity<Page<Instructor>> searchInstructorsByName(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        
        return ResponseEntity.ok(instructorService.searchInstructorsByName(firstName, lastName, pageable));
    }
}
