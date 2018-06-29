package com.test.sbmvc.Repository;

import com.test.sbmvc.Entity.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice,Integer> {
}
