package com.test.sbmvc.Repository;

import com.test.sbmvc.Entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart,Integer>{

}
