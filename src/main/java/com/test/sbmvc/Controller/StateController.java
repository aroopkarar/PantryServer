package com.test.sbmvc.Controller;

import com.test.sbmvc.Model.State;
import com.test.sbmvc.Service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StateController{

    @Autowired
    StateService stateService;

    @RequestMapping(value="/getStatesByCountry",method=RequestMethod.GET)
    public List<State> getStatesByCountry(@RequestParam int countryId)
    {
        return stateService.getStatesByCountry(countryId);
    }

}
