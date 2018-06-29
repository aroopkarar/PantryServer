package com.test.sbmvc.Repository;

import com.test.sbmvc.Entity.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem,Long>{
}
