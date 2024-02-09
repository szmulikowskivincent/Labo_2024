package be.tftic.spring.demo.bll.services;

import be.tftic.spring.demo.domain.entities.Photo;

import java.util.List;
import java.util.Optional;

public interface PhotoService {

    List<Photo> getAllPhotos();

    Optional<Photo> getPhotoById(Long id);

    Photo createPhoto(Photo photo);

    Photo updatePhoto(Long id, Photo updatedPhoto);

    void deletePhoto(Long id);
}

