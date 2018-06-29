
package com.pantryadmin.Repository;

import com.pantryadmin.Entity.Subcategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryRepository extends CrudRepository<Subcategory, Integer> {

}
