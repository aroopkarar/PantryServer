package com.test.sbmvc.Service;

import com.test.sbmvc.Model.Orders;
import com.test.sbmvc.Repository.OrderLineRepository;
import com.test.sbmvc.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderLineRepository orderLineRepository;

    //Working
    public Orders createOrder(Orders order) {
        Orders orderCreated=orderRepository.save(order);
        orderCreated.getOrderlines().stream().forEach(orderline->{
                 orderline.setOrderId(orderCreated.getId());
                 orderLineRepository.save(orderline);
        });
        return orderCreated;
    }

}
