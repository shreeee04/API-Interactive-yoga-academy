package com.example.artf.Controller;

import com.example.artf.Model.YogaClass;
import com.example.artf.Service.YogaClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/yoga-classes")
public class YogaClassController {

    private final YogaClassService yogaClassService;

    @Autowired
    public YogaClassController(YogaClassService yogaClassService) {
        this.yogaClassService = yogaClassService;
    }

    // Create Yoga Class
    @PostMapping
    public ResponseEntity<YogaClass> createYogaClass(@RequestBody YogaClass yogaClass) {
        YogaClass savedYogaClass = yogaClassService.createYogaClass(yogaClass);
        return new ResponseEntity<>(savedYogaClass, HttpStatus.CREATED);
    }

    // Get Yoga Class by ID
    @GetMapping("/{id}")
    public ResponseEntity<YogaClass> getYogaClassById(@PathVariable Long id) {
        Optional<YogaClass> yogaClass = yogaClassService.getYogaClassById(id);
        return yogaClass.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get All Yoga Classes
    @GetMapping
    public List<YogaClass> getAllYogaClasses() {
        return yogaClassService.getAllYogaClasses();
    }

    // Update Yoga Class
    @PutMapping("/{id}")
    public ResponseEntity<YogaClass> updateYogaClass(@PathVariable Long id, @RequestBody YogaClass yogaClassDetails) {
        YogaClass updatedYogaClass = yogaClassService.updateYogaClass(id, yogaClassDetails);
        return updatedYogaClass != null ? ResponseEntity.ok(updatedYogaClass) : ResponseEntity.notFound().build();
    }

    // Delete Yoga Class
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteYogaClass(@PathVariable Long id) {
        yogaClassService.deleteYogaClass(id);
        return ResponseEntity.noContent().build();
    }

    // Get Yoga Classes by Instructor ID
    @GetMapping("/instructor/{instructorId}")
    public List<YogaClass> getYogaClassesByInstructor(@PathVariable Long instructorId) {
        return yogaClassService.getYogaClassesByInstructor(instructorId);
    }

    // Search Yoga Classes by Name
    @GetMapping("/search")
    public List<YogaClass> searchYogaClassesByName(@RequestParam String name) {
        return yogaClassService.searchYogaClassesByName(name);
    }
}
