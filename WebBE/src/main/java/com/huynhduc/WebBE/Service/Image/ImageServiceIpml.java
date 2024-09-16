package com.huynhduc.WebBE.Service.Image;

import com.cloudinary.Cloudinary;
import com.huynhduc.WebBE.Dao.ImageRepository;
import com.huynhduc.WebBE.Entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ImageServiceIpml implements ImageService{
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public ResponseEntity<?> uploadImage(MultipartFile[] file, String name) {
        List<String> urlImages = new ArrayList<>();
        try {
            for(MultipartFile fileItem : file) {
                String url = cloudinary.uploader().upload(fileItem.getBytes(),Map.of("public_id",name)).get("url").toString();
                urlImages.add(url);
            }

            for(String imageUrl : urlImages) {
                Image image = new Image();
                image.setImageURL(imageUrl);
                image.setName(name);
                imageRepository.save(image);
            }
            return ResponseEntity.ok(urlImages);
        } catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }
}
