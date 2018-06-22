package com.test.sbmvc.Controller;

import com.test.sbmvc.Model.Cart;
import com.test.sbmvc.Model.CartItem;
import com.test.sbmvc.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class CartController{

    @Autowired
    CartService cartService;

    //Working fine
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET,value="/addToCart")
    public void addToCart(@RequestParam int productId, @RequestParam int cartId)
    {
        cartService.addProductToCart(productId,cartId);
    }

    //Working fine
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET,value="/removeFromCart")
    public void removeFromCart(@RequestParam int productId,@RequestParam int cartId)
    {
        cartService.removeProductFromCart(productId,cartId);
    }

    //Working fine
    @RequestMapping(method = RequestMethod.GET,value="/getAllFromCart")
    public Set<CartItem> getAllFromCart(@RequestParam int cartId)
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

    //Working Fine
    @RequestMapping(method = RequestMethod.GET,value="/getCart")
    public Cart getCart(@RequestParam int cartId)
    {
        return cartService.getCart(cartId);
    }


    @RequestMapping(value="/updateCartItem")
    public CartItem updateCartItem(@RequestBody CartItem cartItem)
    {
        return cartService.updateCartItem(cartItem);
    }

}
