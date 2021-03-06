package com.pantryadmin.Service;

import com.pantryadmin.Entity.Cart;
import com.pantryadmin.Entity.CartItem;
import com.pantryadmin.Entity.Product;
import com.pantryadmin.Repository.CartItemRepository;
import com.pantryadmin.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartService{

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductService productService;

    @Autowired
    CartItemRepository cartItemRepository;

    //Working Fine
    public void addProductToCart(int productId,int cartId)
    {
        Product product=productService.getProduct(productId);

        CartItem item = new CartItem();
        item.setDateAdded(new Date());
        item.setProduct(product);
        item.setQuantity(1);
        item.setCartId(cartId);


        Optional<Cart> cart=cartRepository.findById(cartId);
        if(cart.isPresent())
        {
          cart.get().getCartItems().add(item);
          cartRepository.save(cart.get());
          System.out.println("Added to cart successfully");
        }
    }

    //Working Fine
    public void removeProductFromCart(int productId, int cartId)
    {
        CartItem item = null;

        Optional<Cart> cart=cartRepository.findById(cartId);
        if(cart.isPresent())
        {
            Iterator<CartItem> it=cart.get().getCartItems().iterator();
            while(it.hasNext()){
                CartItem cartItem = it.next();
                    if(cartItem.getProduct().getId()==productId){
                                item=new CartItem();
                        item=cartItem;
                        break;
                    }
                }
            }
            if(item!=null) {
                    cart.get().getCartItems().remove(item);
                    cartItemRepository.delete(item);
                    System.out.println("Removed from cart successfully");
            }
            else
                System.out.println("Not Removed from cart");
        }

    //Working Fine
    public Set<CartItem> getProductsInCart(int cartId)
    {
        Optional<Cart> cart=cartRepository.findById(cartId);
        System.out.println("Getting All products from Cart: "+cartId);
        if(cart.isPresent())
        {
            if(cart.get().getCartItems()!=null || cart.get().getCartItems().size()>0)
            {
                return  cart.get().getCartItems();
            }
        }
        return null;
    }

    //Working Fine
    public int getProductsCountInCart(int cartId)
    {
        Optional<Cart> cart=cartRepository.findById(cartId);
        System.out.println("Getting cart count");
        if(cart.isPresent())
        {
            if(cart.get().getCartItems()!=null || cart.get().getCartItems().size()>0)
            return cart.get().getCartItems().size();
        }
            return (int)0;
    }

    //Working Fine
    public void clearCart(int cartId)
    {
        Optional<Cart> cart=cartRepository.findById(cartId);
        if(cart.isPresent())
        {
            Iterator<CartItem> it=cart.get().getCartItems().iterator();
            Set<CartItem> cartItems=new HashSet<>();
            while(it.hasNext()){
                CartItem cartItem= new CartItem();
                cartItem=it.next();
                cartItems.add(cartItem);
            };
            cart.get().getCartItems().removeAll(cartItems);
            cartItemRepository.deleteAll(cartItems);
        }
        System.out.println("Removed All from cart successfully");
    }

    public Cart getCart(int cartId) {
        Optional<Cart> cart=cartRepository.findById(cartId);
        if(cart.isPresent())
        {
            return cart.get();
        }
        else return null;
    }

    public CartItem updateCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }
}
