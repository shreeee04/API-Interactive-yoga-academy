package com.example.artf.Controller;

import com.example.artf.Model.InstructionalVideo;
import com.example.artf.Service.InstructionalVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/videos")
public class InstructionalVideoController {

    private final InstructionalVideoService instructionalVideoService;

    @Autowired
    public InstructionalVideoController(InstructionalVideoService instructionalVideoService) {
        this.instructionalVideoService = instructionalVideoService;
    }

    // Create or Update Instructional Video
    @PostMapping
    public ResponseEntity<InstructionalVideo> createOrUpdateVideo(@RequestBody InstructionalVideo instructionalVideo) {
        InstructionalVideo savedVideo = instructionalVideoService.saveInstructionalVideo(instructionalVideo);
        return new ResponseEntity<>(savedVideo, HttpStatus.CREATED);
    }

    // Get Video by ID
    @GetMapping("/{id}")
    public ResponseEntity<InstructionalVideo> getVideoById(@PathVariable Long id) {
        Optional<InstructionalVideo> instructionalVideo = instructionalVideoService.getInstructionalVideoById(id);
        return instructionalVideo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get All Videos
    @GetMapping
    public List<InstructionalVideo> getAllVideos() {
        return instructionalVideoService.getAllInstructionalVideos();
    }

    // Delete Video by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id) {
        instructionalVideoService.deleteInstructionalVideo(id);
        return ResponseEntity.noContent().build();
    }

    // Get Videos by Yoga Class ID
    @GetMapping("/yoga-class/{yogaClassId}")
    public List<InstructionalVideo> getVideosByYogaClassId(@PathVariable Long yogaClassId) {
        return instructionalVideoService.getVideosByYogaClassId(yogaClassId);
    }

    // Get Videos by User ID
    @GetMapping("/user/{userId}")
    public List<InstructionalVideo> getVideosByUserId(@PathVariable Long userId) {
        return instructionalVideoService.getVideosByUserId(userId);
    }

    // Get Video by Title
    @GetMapping("/title/{title}")
    public ResponseEntity<InstructionalVideo> getVideoByTitle(@PathVariable String title) {
        Optional<InstructionalVideo> video = instructionalVideoService.getVideoByTitle(title);
        return video.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get Videos by Title Keyword
    @GetMapping("/search")
    public List<InstructionalVideo> getVideosByKeywordInTitle(@RequestParam String keyword) {
        return instructionalVideoService.getVideosByKeywordInTitle(keyword);
    }
}
