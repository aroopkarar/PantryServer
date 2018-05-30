package com.test.sbmvc.Repository;

import com.test.sbmvc.Model.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends CrudRepository<State, Integer>{

    public List<State> findByCountryId(int countryId);
}
