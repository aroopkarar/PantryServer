package com.pantryadmin.Controller;

import com.pantryadmin.Entity.Orders;
import com.pantryadmin.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value="/createOrder") //Working fine
    public Orders createOrder(@RequestParam int userId) {
        return orderService.createOrder(userId);
    }

    @RequestMapping(value="/getOrder") //Working fine
    public Orders getOrder(@RequestParam int orderId){
        return orderService.getOrder(orderId);
    }

    @RequestMapping(value="/getAllOrders") //Working fine
    public List<Orders> getAllOrders(@RequestParam int userId){
        return orderService.getAllOrders(userId);
    }

}
