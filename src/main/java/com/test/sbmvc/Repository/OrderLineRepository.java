package com.test.sbmvc.Repository;

import com.test.sbmvc.Entity.OrderLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends CrudRepository<OrderLine,Integer>{
}
