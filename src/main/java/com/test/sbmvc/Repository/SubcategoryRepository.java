
package com.test.sbmvc.Repository;

import com.test.sbmvc.Entity.Subcategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryRepository extends CrudRepository<Subcategory, Integer> {

}
