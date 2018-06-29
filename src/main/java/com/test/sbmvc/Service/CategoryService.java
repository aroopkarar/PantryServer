
package com.test.sbmvc.Service;

import com.test.sbmvc.Entity.Category;
import com.test.sbmvc.Entity.CategoryGroup;
import com.test.sbmvc.Entity.Product;
import com.test.sbmvc.Entity.Subcategory;
import com.test.sbmvc.Repository.CategoryGroupRepository;
import com.test.sbmvc.Repository.CategoryRepository;
import com.test.sbmvc.Repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {

    @Autowired
    CategoryGroupRepository categoryGroupRepository;
    
    @Autowired
    CategoryRepository categoryRepository;
    
    @Autowired
    SubcategoryRepository subcategoryRepository;
    
    public List<Category> getAllCategories()
    {
        List<Category> categories = new ArrayList<Category>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }
    
    public List<CategoryGroup> getAllCategoryGroups()
    {
        List<CategoryGroup> categorygroups = new ArrayList<CategoryGroup>();
        categoryGroupRepository.findAll().forEach(categorygroups::add);
        return categorygroups;
    }
    
    public List<Subcategory> getAllSubcategories()
    {
        List<Subcategory> subcategories = new ArrayList<Subcategory>();
        subcategoryRepository.findAll().forEach(subcategories::add);
        return subcategories;
    }

    public CategoryGroup getCategoryGroup(int groupId) {
        Optional<CategoryGroup> categorygroup;
        categorygroup=categoryGroupRepository.findById(groupId);
        return categorygroup.get();
    }

   public List<Product> getProductsByCategoryGroup(int groupId) {
        List<Product> products= new ArrayList<Product>();
        categoryGroupRepository.findById(groupId).get().getCategories().forEach(categories->{
            categories.getSubcategories().forEach((subCategories)->{
                subCategories.getProducts().forEach(products::add);
            });
        });
        return products;
    }

    public List<Product> getProductsByCategoryGroupAndCategory(int groupId, int categoryId) {
        List<Product> products= new ArrayList<Product>();
        categoryGroupRepository.findById(groupId).get().getCategories().forEach(categories->{
            if(categories.getCategoryId()==categoryId)
            {
                categories.getSubcategories().forEach((subCategories)->{
                    subCategories.getProducts().forEach(products::add);
                });
            }
        });
        return products;
    }
    
}
