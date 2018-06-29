package com.test.sbmvc.Repository;

import com.test.sbmvc.Entity.Zip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipRepository extends CrudRepository<Zip,Integer>{
}
