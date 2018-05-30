package com.test.sbmvc.Repository;

import com.test.sbmvc.Model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product,Integer>{

    public Product findById(int productId);

    public List<Product> findAllTop10ByNameIgnoreCaseContaining(String nameLike);

    public Page<Product> findByNameOrderByPrice(String name, Pageable pageable);
}
