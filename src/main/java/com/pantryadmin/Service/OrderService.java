package com.pantryadmin.Service;

import com.pantryadmin.Entity.Cart;
import com.pantryadmin.Entity.OrderLine;
import com.pantryadmin.Entity.Orders;
import com.pantryadmin.Entity.User;
import com.pantryadmin.Repository.OrderLineRepository;
import com.pantryadmin.Repository.OrderRepository;
import com.pantryadmin.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderLineRepository orderLineRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartService cartService;

    public Orders createOrder(int userId) {

        Orders order=new Orders();
        Optional<User> user=userRepository.findById(userId);
        Cart cart=user.get().getCart();
        if(cart!=null)
        {
            cart.getCartItems().forEach(cartItem->{
              order.setDateAdded(new Date());
              order.setDateModified(new Date());
              order.setModifiedBy(userId);
              order.setAddedBy(userId);
              order.setUserId(userId);
            });
        }


        Orders orderCreated=orderRepository.save(order);
        System.out.println("Order Created");
        List<OrderLine> orderLines=new LinkedList<>();
        cart.getCartItems().stream().forEach(cartItem->{
            OrderLine orderLine=new OrderLine();
            orderLine.setOrderId(orderCreated.getId());
            orderLine.setProduct(cartItem.getProduct());
            orderLine.setQuantity(cartItem.getQuantity());
            float totalPrice=(cartItem.getQuantity()*cartItem.getProduct().getPrice());
            orderLine.setTotalPrice(totalPrice);
            orderLineRepository.save(orderLine);
            orderLines.add(orderLine);
        });
        System.out.println("Order Line created");
        orderCreated.setOrderlines(orderLines);
        cartService.clearCart(cart.getId());
        return orderCreated;

    }

    public Orders getOrder(int orderId) {
        Optional<Orders> order= orderRepository.findById(orderId);
        if(order.isPresent())
        {
            return order.get();
        }
        return null;
    }

    public List<Orders> getAllOrders(int userId)
    {
        Optional<User> user= userRepository.findById(userId);
        List<Orders> orders=new LinkedList<>();
        if(user.isPresent())
        {
            orders=user.get().getOrders();
        }
        return orders;
    }
}
