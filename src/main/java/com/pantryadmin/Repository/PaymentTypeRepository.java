package com.pantryadmin.Repository;

import com.pantryadmin.Entity.PaymentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTypeRepository extends CrudRepository<PaymentType,Integer> {
}
