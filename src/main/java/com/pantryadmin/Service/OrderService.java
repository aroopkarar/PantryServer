package com.pantryadmin.Service;

import com.pantryadmin.Entity.OrderLine;
import com.pantryadmin.Repository.CartRepository;
import com.pantryadmin.Repository.OrderLineRepository;
import com.pantryadmin.Repository.OrderRepository;
import com.pantryadmin.Repository.UserRepository;
import com.pantryadmin.Entity.Cart;
import com.pantryadmin.Entity.Orders;
import com.pantryadmin.Entity.User;
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
    CartRepository cartRepository;

    @Autowired
    UserRepository userRepository;

    //Working
    public Orders createOrder(int cartId) {

        Orders order=new Orders();
        List<OrderLine> orderLines=order.getOrderlines();
        Optional<Cart> cart=cartRepository.findById(cartId);
        if(cart.isPresent())
        {
            cart.get().getCartItems().forEach(cartItem->{
              order.setDateAdded(new Date());
              order.setDateModified(new Date());
            });
        }


        Orders orderCreated=orderRepository.save(order);
        orderCreated.getOrderlines().stream().forEach(orderline->{
                 orderline.setOrderId(orderCreated.getId());
                 orderLineRepository.save(orderline);
        });
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
