package com.example.artf.Service;

import com.example.artf.Model.InstructionalVideo;
import com.example.artf.Repository.InstructionalVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructionalVideoService {

    private final InstructionalVideoRepository instructionalVideoRepository;

    @Autowired
    public InstructionalVideoService(InstructionalVideoRepository instructionalVideoRepository) {
        this.instructionalVideoRepository = instructionalVideoRepository;
    }

    // CRUD Operations
    public InstructionalVideo saveInstructionalVideo(InstructionalVideo instructionalVideo) {
        return instructionalVideoRepository.save(instructionalVideo);
    }

    public Optional<InstructionalVideo> getInstructionalVideoById(Long id) {
        return instructionalVideoRepository.findById(id);
    }

    public List<InstructionalVideo> getAllInstructionalVideos() {
        return instructionalVideoRepository.findAll();
    }

    public void deleteInstructionalVideo(Long id) {
        instructionalVideoRepository.deleteById(id);
    }

    // Custom Queries
    public List<InstructionalVideo> getVideosByYogaClassId(Long yogaClassId) {
        return instructionalVideoRepository.findByYogaClassId(yogaClassId);
    }

    public List<InstructionalVideo> getVideosByUserId(Long userId) {
        return instructionalVideoRepository.findByUserId(userId);
    }

    public Optional<InstructionalVideo> getVideoByTitle(String title) {
        return instructionalVideoRepository.findByTitle(title);
    }

    public List<InstructionalVideo> getVideosByKeywordInTitle(String keyword) {
        return instructionalVideoRepository.findByTitleContaining(keyword);
    }
}
