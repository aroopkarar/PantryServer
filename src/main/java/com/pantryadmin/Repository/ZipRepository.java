package com.pantryadmin.Repository;

import com.pantryadmin.Entity.Zip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipRepository extends CrudRepository<Zip,Integer>{
}
