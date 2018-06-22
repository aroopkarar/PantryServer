package com.test.sbmvc.Controller;

import com.test.sbmvc.Model.Orders;
import com.test.sbmvc.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
