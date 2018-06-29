package com.pantryadmin.Controller;

import com.pantryadmin.Entity.Zip;
import com.pantryadmin.Service.ZipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ZipController {

    @Autowired
    ZipService zipService;

    @GetMapping(value="/getAllZipCodes") //Working fine
    public List<Zip> getAllZipCodes()
    {
        return zipService.getAllZipCodes();
    }

    @GetMapping(value="/getZipByCity")  //Working fine
    public List<Zip> getZipByCity(@RequestParam int cityId)
    {
        return zipService.getZipByCity(cityId);
    }
}
