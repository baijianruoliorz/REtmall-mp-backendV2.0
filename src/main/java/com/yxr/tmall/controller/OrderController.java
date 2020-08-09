package com.yxr.tmall.controller;


import com.yxr.tmall.commonUtils.R;
import com.yxr.tmall.entity.Order;
import com.yxr.tmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liqiqiorz
 * @since 2020-08-08
 */
@RestController
@RequestMapping("/tmall/order")
public class OrderController {
@Autowired
private OrderService orderService;
    @GetMapping("getOrderInfo/{orderId}")
    public R getOrderInfo(@PathVariable String orderId){
        Order order = orderService.getById(orderId);
        return R.ok().data("order",order);
    }

    @PostMapping("updateOrder")
    public R updateOrder(@RequestBody Order order){
        orderService.updateById(order);
        return R.ok();
    }
    @DeleteMapping("detelete/{orderId}")
    public R deleteOrder(@PathVariable int orderId)
    {
        boolean b = orderService.removeById(orderId);
        return R.ok();
    }

    @PostMapping("addOrder")
    public R addOrder(@RequestBody Order order){
        orderService.save(order);
        return R.ok();
    }
}

