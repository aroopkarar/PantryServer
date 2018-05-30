
package com.test.sbmvc.Repository;

import com.test.sbmvc.Model.CategoryGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryGroupRepository extends CrudRepository<CategoryGroup, Integer> {

}
