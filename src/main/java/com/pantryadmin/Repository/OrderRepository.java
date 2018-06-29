package com.pantryadmin.Repository;

import com.pantryadmin.Entity.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Orders,Integer> {
}
