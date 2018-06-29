package com.test.sbmvc.Repository;

import com.test.sbmvc.Entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Integer>{

}
