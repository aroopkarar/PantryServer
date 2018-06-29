package com.pantryadmin.Service;

import com.pantryadmin.Entity.City;
import com.pantryadmin.Entity.Zip;
import com.pantryadmin.Repository.CityRepository;
import com.pantryadmin.Repository.ZipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ZipService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    ZipRepository zipRepository;

    public List<Zip> getZipByCity(int cityId)
    {
        List<Zip> zips=new LinkedList<>();
        Optional<City> city=cityRepository.findById(cityId);
        if(city.isPresent())
        {
            city.get().getZips().stream().forEach(zip->{
                zips.add(zip);
            });
        }
        return zips;
    }

    public List<Zip> getAllZipCodes()
    {
            List<Zip> zips=new LinkedList<>();
            zipRepository.findAll().forEach(zips::add);
            zips=zips.stream().sorted(Comparator.comparing(Zip::getZipCode)).collect(Collectors.toList());
            return zips;
    }
}
