package com.pantryadmin.Controller;

import com.pantryadmin.Entity.Address;
import com.pantryadmin.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping(value="/getUserAddresses") //Working Fine
    public List<Address> getUserAddresses(@RequestParam int userId)
    {
        return addressService.getUserAddresses(userId);
    }

    @PostMapping(value="/addUserAddress") //Working Fine
    public boolean addUserAddress(@RequestBody Address address) {
        return addressService.addUserAddress(address);
    }

    @GetMapping(value = "/deleteUserAddress") //Working Fine
    public boolean deleteUserAddress(@RequestParam int addressId)
    {
        return addressService.deleteUserAddress(addressId);
    }

}
