package com.example.artf.Repository;

import com.example.artf.Model.YogaClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YogaClassRepository extends JpaRepository<YogaClass, Long> {

    // Find Yoga Classes by Instructor ID
    List<YogaClass> findByInstructor_Id(Long instructorId);

    // Find Yoga Classes by Name (Partial match)
    List<YogaClass> findByNameContaining(String name);
}
