package com.huynhduc.WebBE.Controller;

import com.huynhduc.WebBE.Entity.Image;
import com.huynhduc.WebBE.Entity.Notify;
import com.huynhduc.WebBE.Service.Image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) {
        ResponseEntity<?> image = imageService.uploadImage(file, name);

        if(image != null) {
            return ResponseEntity.ok(image);
        } else {
            return ResponseEntity.badRequest().body(new Notify("Upload Failed"));
        }
    }
}
