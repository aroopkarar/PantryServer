package com.test.sbmvc.Controller;

import com.test.sbmvc.Model.Product;
import com.test.sbmvc.Service.CartService;
import com.test.sbmvc.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController{

    @Autowired
    CartService cartService;

    @Autowired
    ProductService productService;

    //Working fine
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET,value="/addToCart")
    public void addToCart(@RequestParam int productId, @RequestParam int cartId)
    {
        Product product=productService.getProduct(productId);
        cartService.addProductToCart(product,cartId);
    }

    //Working fine
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET,value="/removeFromCart")
    public void removeFromCart(@RequestParam int productId,@RequestParam int cartId)
    {
        Product product=productService.getProduct(productId);
        cartService.removeProductFromCart(product,cartId);
    }

    //Working fine
    @RequestMapping(method = RequestMethod.GET,value="/getAllFromCart")
    public List<Product> getAllFromCart(@RequestParam int cartId)
    {
        return cartService.getProductsInCart(cartId);
    }

    //Working fine
    @RequestMapping(value = "/getCartCount")
    public int getCartCount(@RequestParam int cartId)
    {
        return cartService.getProductsCountInCart(cartId);
    }

    //Working fine
    @ResponseBody
    @RequestMapping(value = "/clearCart")
    public void clearCart(@RequestParam int cartId)
    {
        cartService.clearCart(cartId);
    }


}
