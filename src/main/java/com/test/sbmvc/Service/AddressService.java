package com.test.sbmvc.Service;

import com.test.sbmvc.Model.Address;
import com.test.sbmvc.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getUserAddress(int userId) {
        List<Address> userAddresses= new LinkedList<>();
        addressRepository.findByUserId(userId).forEach(userAddresses::add);
        return userAddresses;
    }

    public void addUserAddress(Address address) {
        addressRepository.save(address);
    }
}
