package com.pantryadmin.Controller;

import com.pantryadmin.Service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;

    @PostMapping(value="/uploadFile")
    public String uploadFile(@RequestBody MultipartFile file)
    {
        return fileUploadService.uploadFile(file);
    }

    @GetMapping(value="/getUploadedFileUrl")
    public String getUploadedFileUrl(@RequestParam String url)
    {
        return fileUploadService.getUploadedFileUrl(url);
    }
}
