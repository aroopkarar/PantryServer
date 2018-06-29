
package com.pantryadmin.Repository;

import com.pantryadmin.Entity.CategoryGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryGroupRepository extends CrudRepository<CategoryGroup, Integer> {

}
