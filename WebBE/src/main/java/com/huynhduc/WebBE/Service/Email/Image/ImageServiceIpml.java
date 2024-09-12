package com.huynhduc.WebBE.Service.Email.Image;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class ImageServiceIpml implements ImageService{
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public String uploadImage(MultipartFile file, String name) {
        String url = "";
        try {
            url = cloudinary.uploader()
                    .upload(file.getBytes(), Map.of("public_id",name))
                    .get("url")
                    .toString();
        } catch (Exception e){
            e.printStackTrace();
        }
        return url;
    }
}
