package com.huynhduc.WebBE.Service.Image;

import com.cloudinary.Cloudinary;
import com.huynhduc.WebBE.Dao.ImageRepository;
import com.huynhduc.WebBE.Entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class ImageServiceIpml implements ImageService{
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public ResponseEntity<?> uploadImage(MultipartFile file, String name) {
        String url = "";
        try {
            url = cloudinary.uploader()
                    .upload(file.getBytes(), Map.of("public_id",name))
                    .get("url")
                    .toString();

            Image image = new Image();
            image.setImageURL(url);
            image.setName(name);
            imageRepository.save(image);
            return ResponseEntity.ok(image);
        } catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }
}
