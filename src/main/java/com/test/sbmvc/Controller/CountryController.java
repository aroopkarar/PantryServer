package com.test.sbmvc.Controller;

import com.test.sbmvc.Entity.Country;
import com.test.sbmvc.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController{

    @Autowired
    CountryService countryService;

    @RequestMapping(method=RequestMethod.GET,value="/getAllCountries")
    public List<Country> getAllCountries()
    {
        return countryService.getAllCountries();
    }
}
