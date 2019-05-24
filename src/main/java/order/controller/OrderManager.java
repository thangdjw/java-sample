package order.controller;

import order.model.OrderEntity;
import order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/order")
public class OrderManager {
    @Autowired
    private OrderService orderService;
    private Logger logger = Logger.getLogger(OrderManager.class.getName());

    @PostMapping
    public boolean newOrder(OrderEntity orderInfo) {
        orderService.addOrder(orderInfo);
        return true;
    }

    @GetMapping("/{id}")
    public OrderEntity getOrder(String id) {
        return orderService.findById(id);
    }

    @PutMapping("/{id}")
    public boolean updateOrder(String id, OrderEntity order){
        logger.info(order.toString());
        orderService.updateOrder(order);
        return true;
    }
}
