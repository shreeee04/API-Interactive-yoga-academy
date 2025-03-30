package com.example.artf.Repository;

import com.example.artf.Model.InstructionalVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstructionalVideoRepository extends JpaRepository<InstructionalVideo, Long> {

    @Query("SELECT iv FROM InstructionalVideo iv WHERE iv.yogaClass.id = ?1")
    List<InstructionalVideo> findByYogaClassId(Long yogaClassId);

    @Query("SELECT iv FROM InstructionalVideo iv WHERE iv.user.id = ?1")
    List<InstructionalVideo> findByUserId(Long userId);

    Optional<InstructionalVideo> findByTitle(String title);

    @Query("SELECT iv FROM InstructionalVideo iv WHERE iv.title LIKE %?1%")
    List<InstructionalVideo> findByTitleContaining(String keyword);
}
