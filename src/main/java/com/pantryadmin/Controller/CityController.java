package com.pantryadmin.Controller;

import com.pantryadmin.Entity.City;
import com.pantryadmin.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController{

        @Autowired
        CityService cityService;

        @RequestMapping(value="/getAllCitiesByState",method=RequestMethod.GET)
        public List<City> getAllCitiesByState(@RequestParam int stateId) //Working fine
        {
                return cityService.getCitiesByState(stateId);
        }
}
