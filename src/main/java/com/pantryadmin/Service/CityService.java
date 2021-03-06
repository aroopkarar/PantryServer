package com.pantryadmin.Service;

import com.pantryadmin.Repository.StateRepository;
import com.pantryadmin.Entity.City;
import com.pantryadmin.Entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService{

    @Autowired
    StateRepository stateRepository;

    public List<City> getCitiesByState(int stateId)
    {
        Optional<State> st=stateRepository.findById(stateId);
        if(st.isPresent())
         return  st.get().getCities();
        return  null;
    }
}

