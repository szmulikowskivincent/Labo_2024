package be.tftic.spring.demo.domain.entities;

import be.tftic.spring.demo.api.model.dto.VideoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;


    @Getter
    @AllArgsConstructor
    @Entity
    @Table(name = "VIDEO")
    public class Video {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID_VIDEO")
        private Long idVideo;

        @Column(name = "VIDEO_URL", length = 2500)
        private String videoUrl;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        public Video() {
        }

        public Video(Long idVideo) {
            this.idVideo = idVideo;
        }

        public static Video fromDTO(VideoDTO videoDTO) {
            Video video = new Video();
            video.setIdVideo(videoDTO.getIdVideo());
            video.setVideoUrl(videoDTO.getVideoUrl());

            return video;
        }

        public Video(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public void setIdVideo(Long idVideo) {
            this.idVideo = idVideo;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }
    }
