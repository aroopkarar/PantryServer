package com.pantryadmin.Controller;

import com.pantryadmin.Entity.CartItem;
import com.pantryadmin.Entity.Cart;
import com.pantryadmin.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class CartController{

    @Autowired
    CartService cartService;

    @RequestMapping(method = RequestMethod.GET,value="/addToCart")
    public void addToCart(@RequestParam int productId, @RequestParam int cartId) //Working fine
    {
        cartService.addProductToCart(productId,cartId);
    }


    @RequestMapping(method = RequestMethod.GET,value="/removeFromCart")
    public void removeFromCart(@RequestParam int productId,@RequestParam int cartId) //Working fine
    {
        cartService.removeProductFromCart(productId,cartId);
    }


    @RequestMapping(method = RequestMethod.GET,value="/getAllFromCart") //Working fine
    public Set<CartItem> getAllFromCart(@RequestParam int cartId)
    {
        return cartService.getProductsInCart(cartId);
    }


    @RequestMapping(value = "/getCartCount") //Working fine
    public int getCartCount(@RequestParam int cartId)
    {
        return cartService.getProductsCountInCart(cartId);
    }


    @RequestMapping(value = "/clearCart") //Working fine
    public void clearCart(@RequestParam int cartId)
    {
        cartService.clearCart(cartId);
    }


    @RequestMapping(method = RequestMethod.GET,value="/getCart") //Working Fine
    public Cart getCart(@RequestParam int cartId)
    {
        return cartService.getCart(cartId);
    }


    @RequestMapping(value="/updateCartItem") //Working Fine
    public CartItem updateCartItem(@RequestBody CartItem cartItem)
    {
        return cartService.updateCartItem(cartItem);
    }

}
