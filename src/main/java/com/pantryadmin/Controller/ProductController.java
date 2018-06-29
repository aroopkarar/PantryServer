package com.pantryadmin.Controller;

import com.pantryadmin.Entity.Product;
import com.pantryadmin.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @ResponseBody
    @RequestMapping(value = "/getProduct",method = RequestMethod.GET)
    public Product getProduct(@RequestParam("productId") int productId)
    {
        return productService.getProduct(productId);
    }

    @ResponseBody
    @RequestMapping(value = "/getAllProducts",method = RequestMethod.POST)
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @ResponseBody
    @RequestMapping(value="/getProductsByName", method=RequestMethod.POST)
    public List<Product> getProductsByName(@RequestParam("productName") String productName)
    {
        return productService.getProductsNameLike(productName);
    }

    @ResponseBody
    @RequestMapping(value="/saveProduct",method=RequestMethod.POST)
    public void saveProduct(@RequestBody Product product)
    {
            productService.saveProduct(product);
    }

    @ResponseBody
    @RequestMapping(value="/updateProduct",method=RequestMethod.POST)
    public void updateProduct(@RequestBody Product product)
    {
        productService.updateProduct(product);
    }

    @ResponseBody
    @RequestMapping(value="/deleteProduct",method=RequestMethod.POST)
    public void deleteProduct(@RequestParam("productId") int productId)
    {
        productService.deleteProduct(productId);
    }
}
