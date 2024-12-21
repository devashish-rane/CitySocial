package com.devashish.citysocial.one.services;

import com.devashish.citysocial.one.domain.Image;
import com.devashish.citysocial.one.repo.ImageRepo;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    ImageRepo imageRepo;

    ImageService(ImageRepo imageRepo){
        this.imageRepo = imageRepo;
    }

    public boolean uploadImage(Image image){
        Image returnedImg = this.imageRepo.save(image);

        if(returnedImg != null){
            return true;
        }
        else{
            return false;
        }
    }

    public Image downloadImage(String name){
        return this.imageRepo.findByName(name);
    }
}
