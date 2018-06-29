package com.pantryadmin.Service;

import com.pantryadmin.Repository.StateRepository;
import com.pantryadmin.Entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class StateService{

    @Autowired
    StateRepository stateRepository;

    public List<State> getStatesByCountry(int countryId)
    {
        List<State> states= new LinkedList<State>();
        stateRepository.findByCountryId(countryId).forEach(states::add);
        return states;
    }
}
