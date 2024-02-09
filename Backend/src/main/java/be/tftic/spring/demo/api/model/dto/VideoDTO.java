package be.tftic.spring.demo.api.model.dto;

import be.tftic.spring.demo.domain.entities.Video;
import lombok.Getter;

@Getter
public class VideoDTO {

    private final Long idVideo;
    private final String videoUrl;
    private final Long userId;

    public VideoDTO(Long idVideo, String videoUrl, Long userId) {
        this.idVideo = idVideo;
        this.videoUrl = videoUrl;
        this.userId = userId;
    }

    public Video toVideoEntity() {
        Video video = new Video();
        video.setIdVideo(this.idVideo);
        video.setVideoUrl(this.videoUrl);

        return video;
    }
}




