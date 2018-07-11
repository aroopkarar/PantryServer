package com.pantryadmin.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class FileUploadService {

    public String uploadFile(MultipartFile file, String folderName) {

        String uploadedFileUrl = null;
        if (file != null && !(file.getOriginalFilename().isEmpty())) {

            try {
                File tempfile = File.createTempFile(folderName.toLowerCase() + "_", "");
                InputStream inputStream = file.getInputStream();
                OutputStream outputStream = new FileOutputStream(tempfile);
                IOUtils.copy(inputStream, outputStream);
                Cloudinary cloudinary = new Cloudinary();
                Map<?, ?> configMap = ObjectUtils.asMap("cloud_name", "dvdwbalfr",
                        "api_key", "484217463886824", "api_secret", "cf67a8tRkel1a_fwu1nzq9nB1Yg",
                        "public_id",
                        "PANTRY" + "/" + folderName.toLowerCase() + "_" + file.getOriginalFilename() + LocalDateTime.now()
                                .toString(),
                        "use_filename", true, "unique_filename", true);
                Map<String, String> fileDetailMap = cloudinary.uploader().upload(tempfile, configMap);

                if (!fileDetailMap.isEmpty()) {
                    uploadedFileUrl = fileDetailMap.get("url");
                }
                tempfile.delete();
            } catch (IOException e) {
                System.out.println("####Exception in uploadFile###"+e);
            }
        }
        return uploadedFileUrl;
    }
}
