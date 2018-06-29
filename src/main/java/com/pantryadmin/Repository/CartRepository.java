package com.pantryadmin.Repository;

import com.pantryadmin.Entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart,Integer>{

}
