package com.pantryadmin.Repository;

import com.pantryadmin.Entity.OrderLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends CrudRepository<OrderLine,Integer>{
}
