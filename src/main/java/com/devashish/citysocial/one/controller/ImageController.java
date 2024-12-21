package com.devashish.citysocial.one.controller;

import com.devashish.citysocial.one.domain.Image;
import com.devashish.citysocial.one.services.ImageService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


@RestController
public class ImageController {

    private ImageService imageService;

    ImageController(ImageService imageService){
        this.imageService = imageService;
    }


    @PostMapping("/image")
    ResponseEntity<String> postImage(@RequestParam("file") MultipartFile multipartFile) {
        byte[] imageData = new byte[0];
        if(!multipartFile.isEmpty()  ){

            try{
                imageData =  multipartFile.getBytes();
            } catch (IOException e) {
                System.out.println("problem while reading mages file");
            }
            Image img = Image.builder()
                    .name("image one")
                    .data(imageData)
                    .build();

            if(imageService.uploadImage(img)) {
                return  ResponseEntity.ok().body("image uploaded" + img.toString());
            }else{
                return ResponseEntity.internalServerError().body("File uploading failure..retry");
            }


        }
        return ResponseEntity.badRequest().body("File might be empty");
    }

    @GetMapping("/image")
    ResponseEntity<byte[]> downlaodImage(@RequestParam("name") String name) {
            byte[] data = imageService.downloadImage(name).getData();
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(data);
    }

}
