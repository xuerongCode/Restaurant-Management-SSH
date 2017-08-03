package com.project_restaurant.web;

import com.project_restaurant.entity.Order;
import com.project_restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by xuero on 2017/8/3.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/list")
    public ModelAndView listingAllOrders(){
        List<Order> orders = orderService.getAllOrders();
        ModelAndView mav = new ModelAndView();
        mav.addObject("orders",orders);
        mav.setViewName("detail/orderList");
        return mav;
    }

    @RequestMapping("/detail/{orderId}")
    public ModelAndView gotoOrderDetailView(@PathVariable("orderId")Integer orderId){
        Order order = orderService.getOrderWithDishById(orderId);
        ModelAndView mav = new ModelAndView();
        mav.addObject("order",order);
        mav.setViewName("detail/orderDetail");
        return mav;
    }
}
