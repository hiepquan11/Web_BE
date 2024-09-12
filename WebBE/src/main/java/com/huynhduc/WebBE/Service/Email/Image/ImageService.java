package com.huynhduc.WebBE.Service.Email.Image;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    String uploadImage(MultipartFile file, String name);

}
