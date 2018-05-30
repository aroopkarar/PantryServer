package com.test.sbmvc.Repository;

import com.test.sbmvc.Model.PaymentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTypeRepository extends CrudRepository<PaymentType,Integer> {
}
