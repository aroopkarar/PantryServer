package com.test.sbmvc.Service;

import com.test.sbmvc.Model.Cart;
import com.test.sbmvc.Model.CartItem;
import com.test.sbmvc.Model.Product;
import com.test.sbmvc.Repository.CartItemRepository;
import com.test.sbmvc.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

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
        /*Optional<Cart> cart=cartRepository.findById(cartId);
        if(cart.isPresent()) {
            cart.get().getProducts().add(p);
            cartRepository.save(cart.get());
            System.out.println("Added to cart successfully");
        }*/
        Product product=productService.getProduct(productId);

        CartItem item = new CartItem();
        item.setDateAdded(new Date());
        item.setProduct(product);
        item.setQuantity(1);


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
        /*Optional<Cart> cart=cartRepository.findById(cartId);
        if(cart.isPresent()) {
            cart.get().getProducts().remove(p);
            cartRepository.save(cart.get());
            System.out.println("Removed from cart successfully");
        }*/
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
                    cartRepository.save(cart.get());
                    cartItemRepository.delete(item);
                    System.out.println("Removed from cart successfully");
            }
            else
                System.out.println("Not Removed from cart");
        }

    //Working Fine
    public Set<CartItem> getProductsInCart(int cartId)
    {
       /* List<Product> products = new LinkedList<>();
        Optional<Cart> cart=cartRepository.findById(cartId);
        if(cart.isPresent()) {
        cart.get().getProducts().forEach(products::add);

            return products;
        }*/

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
        /*Optional<Cart> cart=cartRepository.findById(cartId);
        if(cart.isPresent())
        return cart.get().getProducts().size();
        else*/
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
        /*Optional<Cart> cart=cartRepository.findById(cartId);
        if(cart.isPresent())
        cart.get().getProducts().clear();
        cartRepository.save(cart.get());
        System.out.println("Removed All from cart successfully");*/

        Optional<Cart> cart=cartRepository.findById(cartId);
        if(cart.isPresent())
        {
            cart.get().setCartItems(null);
            cartRepository.save(cart.get());
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
