package be.tftic.spring.demo.api.model.dto;

import be.tftic.spring.demo.domain.entities.Photo;
import lombok.Getter;

@Getter
public class PhotoDTO {

    private Long idPhoto;
    private final String imageUrl;
    private final Long userId;

    public PhotoDTO(Photo photo) {
        this.idPhoto = photo.getIdPhoto();
        this.imageUrl = photo.getImageUrl();
        this.userId = photo.getUser() != null ? photo.getUser().getId() : null;
    }

    public void setIdPhoto(Long idPhoto) {
        this.idPhoto = idPhoto;
    }
}
