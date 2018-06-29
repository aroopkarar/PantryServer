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

    //Working
    @RequestMapping(value="/createOrder",method=RequestMethod.POST)
    @ResponseBody
    public Orders createOrder(@RequestBody int cartId) {
        return orderService.createOrder(cartId);
    }

    @RequestMapping(value="/getOrder",method=RequestMethod.POST)
    @ResponseBody
    public Orders getOrder(@RequestBody int orderId){
        return orderService.getOrder(orderId);
    }

    @RequestMapping(value="/getAllOrders",method=RequestMethod.POST)
    @ResponseBody
    public List<Orders> getAllOrders(@RequestBody int userId){
        return orderService.getAllOrders(userId);
    }

}
