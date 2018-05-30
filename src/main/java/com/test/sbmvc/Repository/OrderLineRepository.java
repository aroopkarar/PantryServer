package com.test.sbmvc.Repository;

import com.test.sbmvc.Model.OrderLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends CrudRepository<OrderLine,Integer>{
}
