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

    @GetMapping(value="/getUserAddresses")
    public List<Address> getUserAddresses(@RequestParam int userId)
    {
        return addressService.getUserAddresses(userId);
    }

    @PostMapping(value="/addUserAddress")
    public boolean addUserAddress(@RequestBody Address address) {
        return addressService.addUserAddress(address);
    }

    @GetMapping(value = "/deleteUserAddress")
    public boolean deleteUserAddress(@RequestParam int addressId)
    {
        return addressService.deleteUserAddress(addressId);
    }

}
