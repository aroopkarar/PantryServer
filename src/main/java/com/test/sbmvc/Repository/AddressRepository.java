package com.test.sbmvc.Repository;

import com.test.sbmvc.Entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address,Integer> {
    List<Address> findByUserId(int userId);
}
