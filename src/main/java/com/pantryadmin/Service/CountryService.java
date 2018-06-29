package com.pantryadmin.Service;

import com.pantryadmin.Repository.CountryRepository;
import com.pantryadmin.Entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CountryService{

    @Autowired
    CountryRepository countryRepository;

    public List<Country> getAllCountries()
    {
        List<Country> countries= new LinkedList<Country>();
        countryRepository.findAll().forEach(countries::add);
        return countries;
    }
}
