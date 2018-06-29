package com.pantryadmin.Controller;

import com.pantryadmin.Entity.Zip;
import com.pantryadmin.Service.ZipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ZipController {

    @Autowired
    ZipService zipService;

    @GetMapping(value="/getAllZipCodes")
    public List<Zip> getAllZipCodes()
    {
        return zipService.getAllZipCodes();
    }

    @GetMapping(value="/getZipByCity")
    public List<Zip> getZipByCity(@RequestParam int cityId)
    {
        return zipService.getZipByCity(cityId);
    }
}
