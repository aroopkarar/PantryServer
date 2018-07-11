package com.pantryadmin.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.pantryadmin.Constants.ApplicationConstant;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class FileUploadService {

    public String uploadFile(MultipartFile file) {

        String uploadedFileUrl = null;
        if (file != null && !(file.getOriginalFilename().isEmpty())) {

            try {
                String folderName=ApplicationConstant.CLOUDINARY_FOLDER_NAME;
                File tempfile = File.createTempFile(folderName.toLowerCase() + "_", "");
                InputStream inputStream = file.getInputStream();
                OutputStream outputStream = new FileOutputStream(tempfile);
                IOUtils.copy(inputStream, outputStream);
                Cloudinary cloudinary = new Cloudinary();
                int fileExtPosition=file.getOriginalFilename().lastIndexOf(".");
                String fileName=file.getOriginalFilename().substring(0,fileExtPosition);
                Map<?, ?> configMap = ObjectUtils.asMap(
                        "cloud_name", ApplicationConstant.CLOUDINARY_CLOUD_NAME,
                                "api_key", ApplicationConstant.CLOUDINARY_API_KEY,
                                "api_secret", ApplicationConstant.CLOUDINARY_API_SECRET,
                                //"folder",ApplicationConstant.CLOUDINARY_FOLDER_NAME ,
                                "public_id",folderName+"/"+fileName +"_" + LocalDateTime.now().toString(),
                                "use_filename", true,
                                "unique_filename", true);
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


    public String getUploadedFileUrl(String url) {
        Cloudinary cloudinary=new Cloudinary(ObjectUtils.asMap(
                "cloud_name", ApplicationConstant.CLOUDINARY_CLOUD_NAME,
                "api_key", ApplicationConstant.CLOUDINARY_API_KEY,
                "api_secret", ApplicationConstant.CLOUDINARY_API_SECRET));
        String[] arr = url.split("/");
        String publicId=arr[arr.length - 2]+"/"+arr[arr.length - 1];
        if (publicId!=null && !publicId.isEmpty()) {
            url=cloudinary.url().transformation(new Transformation().quality(100).dpr((float)2.0)).secure(true).generate(publicId);
        }
        return url;
    }
}
