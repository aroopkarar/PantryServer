package com.test.sbmvc.Service;

import com.test.sbmvc.Model.Address;
import com.test.sbmvc.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getUserAddresses(int userId) {
        List<Address> userAddresses= new LinkedList<>();
        addressRepository.findByUserId(userId).forEach(userAddresses::add);
        return userAddresses;
    }

    public boolean addUserAddress(Address address) {
        Address addr=addressRepository.save(address);
        if(addr!=null)
            return true;
        return false;
    }

    public boolean deleteUserAddress(int addressId) {
        Optional<Address> address=addressRepository.findById(addressId);
        if(address.isPresent()) {
            addressRepository.delete(address.get());
            return true;
        }
        return false;
    }
}
