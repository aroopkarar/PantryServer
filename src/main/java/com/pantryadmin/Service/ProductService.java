package com.pantryadmin.Service;

import com.pantryadmin.Entity.Product;
import com.pantryadmin.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService{

    public ProductRepository getRepository(){
        return repository;
    }

    public void setRepository(ProductRepository repository){
        this.repository = repository;
    }

    @Autowired
    ProductRepository repository;

    public Product getProduct(int product_id){
        return repository.findById(product_id);
    }

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<Product>();
        repository.findAll().forEach(products::add);
        return products;
    }

    public List<Product> getProductsNameLike(String productName)
    {
        List<Product> products= new ArrayList<Product>();
        repository.findAllTop10ByNameIgnoreCaseContaining(productName).forEach(products::add);
        return products;
    }

    //Get products as Paged List
    public Page<Product> getProductsPaginated(String name,
                                              Pageable pageable) {
        return repository.findByNameOrderByPrice(name, pageable);
    }

    public boolean isValid(){
        return true;
    }

    public void saveProduct(Product product){
        repository.save(product);
    }

    public void updateProduct(Product product){
        repository.save(product);
    }

    public void deleteProduct(int productId)
    {
        repository.deleteById(productId);
    }

}
