package com.pantryadmin.Repository;

import com.pantryadmin.Entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer>{
}
