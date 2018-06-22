package com.test.sbmvc.Service;

import com.test.sbmvc.Model.Cart;
import com.test.sbmvc.Model.Orders;
import com.test.sbmvc.Model.OrderLine;
import com.test.sbmvc.Repository.CartRepository;
import com.test.sbmvc.Repository.OrderLineRepository;
import com.test.sbmvc.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

}
