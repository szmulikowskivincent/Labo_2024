package be.tftic.spring.demo.bll.services;


import be.tftic.spring.demo.domain.entities.Video;

import java.util.List;
import java.util.Optional;

public interface VideoService {

    void deleteVideo(Long id);

    Video updateVideo(Long id, Video updatedVideo);

    List<Video> getAllVideos();

    Optional<Video> getVideoById(Long id);

    Video createVideo(Video video);

}
