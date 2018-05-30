package com.test.sbmvc.Controller;

import com.test.sbmvc.Model.Address;
import com.test.sbmvc.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping(value="/getUserAddress")
    public List<Address> getUserAddress(@RequestParam int userId)
    {
        return addressService.getUserAddress(userId);
    }

    @PostMapping(value="/addUserAddress")
    public void addUserAddress(@RequestBody Address address)
    {
        addressService.addUserAddress(address);
    }
}
