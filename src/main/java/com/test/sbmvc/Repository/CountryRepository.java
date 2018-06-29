package com.test.sbmvc.Repository;

import com.test.sbmvc.Entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer>{
}
