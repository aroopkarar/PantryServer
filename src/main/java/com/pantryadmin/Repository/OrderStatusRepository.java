package com.pantryadmin.Repository;

import com.pantryadmin.Entity.OrderStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends CrudRepository<OrderStatus,Integer>{
}
