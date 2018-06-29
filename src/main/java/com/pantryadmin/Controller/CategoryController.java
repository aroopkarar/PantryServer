
package com.pantryadmin.Controller;

import com.pantryadmin.Entity.Category;
import com.pantryadmin.Entity.Product;
import com.pantryadmin.Entity.Subcategory;
import com.pantryadmin.Entity.CategoryGroup;
import com.pantryadmin.Service.CategoryService;
import com.pantryadmin.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CategoryController {

    @Autowired //inject service DI
    CategoryService categoryService;
    
    @Autowired
    ProductService productService;
    
    
    @RequestMapping(value = "/getAllCategoryGroups")
    public List<CategoryGroup> getAllCategoryGroups()
    {
        return categoryService.getAllCategoryGroups();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getCategoryGroupByGroupId")
    public CategoryGroup getCategoryGroup(@RequestParam(value="groupId") int groupId)
    {
        System.out.println("##groupId Received: "+groupId);
        return categoryService.getCategoryGroup(groupId);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/getAllCategories")
    public List<Category> getAllCategories()
    {
        return categoryService.getAllCategories();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAllSubCategories")
    public List<Subcategory> getAllSubCategories()
    {
        return categoryService.getAllSubcategories();
    }

    @RequestMapping("/getProductByName")
    public List<Product> getProductByName(@RequestParam(value="productName") String productName)
    {
    	return productService.getProductsNameLike(productName);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getProductsByCategoryGroup")
    public List<Product> getProductsByCategoryGroup(@RequestParam(value="groupId") int groupId)
    {
        System.out.println("##groupId Received: "+groupId);
        return categoryService.getProductsByCategoryGroup(groupId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getProductsByCategoryGroupAndCategory")
    public List<Product> getProductsByCategoryGroupAndCategory(@RequestParam(value="groupId") int groupId,@RequestParam(value="categoryId") int categoryId)
    {
        System.out.println("##groupId Received: "+groupId);
        System.out.println("##categoryId Received: "+categoryId);
        return categoryService.getProductsByCategoryGroupAndCategory(groupId,categoryId);
    }
}
