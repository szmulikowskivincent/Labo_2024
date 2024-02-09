package be.tftic.spring.demo.bll.impl;

import be.tftic.spring.demo.dal.VideoRepository;
import be.tftic.spring.demo.domain.entities.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import be.tftic.spring.demo.bll.services.VideoService;

import java.util.List;
import java.util.Optional;


@Service
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public void deleteVideo(Long id) {
        videoRepository.deleteById(id);
    }

    @Override
    public Video updateVideo(Long id, Video updatedVideo) {
        return null;
    }

    @Override
    public List<Video> getAllVideos() {
        return null;
    }

    @Override
    public Optional<Video> getVideoById(Long id) {
        return Optional.empty();
    }

    @Override
    public Video createVideo(Video video) {
        return null;
    }
}
