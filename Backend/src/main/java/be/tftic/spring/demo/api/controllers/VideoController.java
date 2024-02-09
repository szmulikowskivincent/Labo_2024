package be.tftic.spring.demo.api.controllers;

import be.tftic.spring.demo.api.model.dto.VideoDTO;
import be.tftic.spring.demo.bll.services.VideoService;
import be.tftic.spring.demo.domain.entities.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping
    public List<VideoDTO> getAllVideos() {
        List<Video> videos = videoService.getAllVideos();

        if ( videos != null ) {
            return videos.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoDTO> getVideoById(@PathVariable Long id) {
        Optional<Video> optionalVideo = videoService.getVideoById(id);

        if ( optionalVideo.isPresent() ) {
            Video video = optionalVideo.get();
            VideoDTO videoDTO = convertToDTO(video);
            return new ResponseEntity<>(videoDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private VideoDTO convertToDTO(Video video) {
        if ( video != null ) {
            return new VideoDTO(video.getIdVideo(), video.getVideoUrl(), video.getUser() != null ? video.getUser().getId() : null);
        } else {
            return null;
        }
    }

    @PostMapping
    public ResponseEntity<VideoDTO> createVideo(@RequestBody VideoDTO videoDTO) {
        Video video = convertToDTO(Video.fromDTO(videoDTO)).toVideoEntity();
        Video createdVideo = videoService.createVideo(video);
        return new ResponseEntity<>(convertToDTO(createdVideo), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id) {
        videoService.deleteVideo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}



