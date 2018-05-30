package com.test.sbmvc.Service;

import com.test.sbmvc.Model.Cart;
import com.test.sbmvc.Model.Product;
import com.test.sbmvc.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService{

    @Autowired
    CartRepository cartRepository;

    //Working Fine
    public void addProductToCart(Product p,int cartId)
    {
        Optional<Cart> cart=cartRepository.findById(cartId);
        if(cart.isPresent()) {
            cart.get().getProducts().add(p);
            cartRepository.save(cart.get());
            System.out.println("Added to cart successfully");
        }
    }

    //Working Fine
    public void removeProductFromCart(Product p, int cartId)
    {
        Optional<Cart> cart=cartRepository.findById(cartId);
        if(cart.isPresent()) {
            cart.get().getProducts().remove(p);
            cartRepository.save(cart.get());
            System.out.println("Removed from cart successfully");
        }
    }

    //Working Fine
    public List<Product> getProductsInCart(int cartId)
    {
        List<Product> products = new LinkedList<>();
        Optional<Cart> cart=cartRepository.findById(cartId);
        if(cart.isPresent()) {
        cart.get().getProducts().forEach(products::add);

            return products;
        }
        return null;
    }

    //Working Fine
    public int getProductsCountInCart(int cartId)
    {
        Optional<Cart> cart=cartRepository.findById(cartId);
        if(cart.isPresent())
        return cart.get().getProducts().size();
        else
            return (int)0;
    }

    //Working Fine
    public void clearCart(int cartId)
    {
        Optional<Cart> cart=cartRepository.findById(cartId);
        if(cart.isPresent())
        cart.get().getProducts().clear();
        cartRepository.save(cart.get());
        System.out.println("Removed All from cart successfully");
    }
}
