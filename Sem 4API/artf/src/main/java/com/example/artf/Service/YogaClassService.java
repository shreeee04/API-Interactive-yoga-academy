package com.example.artf.Service;

import com.example.artf.Model.YogaClass;
import com.example.artf.Repository.YogaClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class YogaClassService {

    private final YogaClassRepository yogaClassRepository;

    @Autowired
    public YogaClassService(YogaClassRepository yogaClassRepository) {
        this.yogaClassRepository = yogaClassRepository;
    }

    // Create YogaClass
    public YogaClass createYogaClass(YogaClass yogaClass) {
        return yogaClassRepository.save(yogaClass);
    }

    // Get YogaClass by ID
    public Optional<YogaClass> getYogaClassById(Long id) {
        return yogaClassRepository.findById(id);
    }

    // Get all YogaClasses
    public List<YogaClass> getAllYogaClasses() {
        return yogaClassRepository.findAll();
    }

    // Update YogaClass
    public YogaClass updateYogaClass(Long id, YogaClass yogaClassDetails) {
        return yogaClassRepository.findById(id).map(yogaClass -> {
            yogaClass.setName(yogaClassDetails.getName());
            yogaClass.setDescription(yogaClassDetails.getDescription());
            yogaClass.setUser(yogaClassDetails.getUser());
            yogaClass.setInstructor(yogaClassDetails.getInstructor());
            return yogaClassRepository.save(yogaClass);
        }).orElse(null);
    }

    // Delete YogaClass by ID
    public void deleteYogaClass(Long id) {
        yogaClassRepository.deleteById(id);
    }

    // Find YogaClasses by Instructor ID
    public List<YogaClass> getYogaClassesByInstructor(Long instructorId) {
        return yogaClassRepository.findByInstructor_Id(instructorId);
    }

    // Search Yoga Classes by Name
    public List<YogaClass> searchYogaClassesByName(String name) {
        return yogaClassRepository.findByNameContaining(name);
    }
}
