package com.test.sbmvc.Repository;

import com.test.sbmvc.Model.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Orders,Integer> {
}
