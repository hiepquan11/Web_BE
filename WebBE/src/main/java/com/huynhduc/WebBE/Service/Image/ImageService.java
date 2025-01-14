package com.huynhduc.WebBE.Service.Image;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    public ResponseEntity<?> uploadImage(MultipartFile[] files, String name);
    public ResponseEntity<?> updateImage(int imageID);

}
