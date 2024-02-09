package be.tftic.spring.demo.bll.impl;

import be.tftic.spring.demo.bll.services.PhotoService;
import be.tftic.spring.demo.dal.PhotoRepository;
import be.tftic.spring.demo.domain.entities.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public List<Photo> getAllPhotos() {
        return null;
    }

    @Override
    public Optional<Photo> getPhotoById(Long id) {
        return Optional.empty();
    }

    @Override
    public Photo createPhoto(Photo photo) {
        return null;
    }

    @Override
    public Photo updatePhoto(Long id, Photo updatedPhoto) {
        if ( photoRepository.existsById(id) ) {
            updatedPhoto.setIdPhoto(id);
            return photoRepository.save(updatedPhoto);
        } else {

            return null;
        }
    }

    @Override
    public void deletePhoto(Long id) {
        photoRepository.deleteById(id);
    }
}




