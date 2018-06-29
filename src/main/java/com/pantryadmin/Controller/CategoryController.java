
package com.pantryadmin.Controller;

import com.pantryadmin.Entity.Category;
import com.pantryadmin.Entity.CategoryGroup;
import com.pantryadmin.Entity.Product;
import com.pantryadmin.Entity.Subcategory;
import com.pantryadmin.Service.CategoryService;
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
    
    @RequestMapping(value = "/getAllCategoryGroups") //Working fine
    public List<CategoryGroup> getAllCategoryGroups()
    {
        return categoryService.getAllCategoryGroups();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getCategoryGroupByGroupId") //Working fine
    public CategoryGroup getCategoryGroup(@RequestParam(value="groupId") int groupId)
    {
        System.out.println("##groupId Received: "+groupId);
        return categoryService.getCategoryGroup(groupId);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/getAllCategories") //Working fine
    public List<Category> getAllCategories()
    {
        return categoryService.getAllCategories();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAllSubCategories") //Working fine
    public List<Subcategory> getAllSubCategories()
    {
        return categoryService.getAllSubcategories();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getProductsByCategoryGroup") //Working fine
    public List<Product> getProductsByCategoryGroup(@RequestParam(value="groupId") int groupId)
    {
        System.out.println("##groupId Received: "+groupId);
        return categoryService.getProductsByCategoryGroup(groupId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getProductsByCategoryGroupAndCategory") //Working fine
    public List<Product> getProductsByCategoryGroupAndCategory(@RequestParam(value="groupId") int groupId,@RequestParam(value="categoryId") int categoryId)
    {
        System.out.println("##groupId Received: "+groupId);
        System.out.println("##categoryId Received: "+categoryId);
        return categoryService.getProductsByCategoryGroupAndCategory(groupId,categoryId);
    }
}
