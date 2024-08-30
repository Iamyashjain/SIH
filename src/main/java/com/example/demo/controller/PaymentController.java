package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.model.ORDER_MODEL;
import com.example.demo.model.User;
import com.example.demo.service.CashfreeService;
import com.example.demo.service.CashfreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private CashfreeService cashfreeService;

    @PostMapping("/create-order")
    public String createOrder(@RequestBody ORDER_MODEL o) {
        // Call the service to create an order
    int amount=o.getAmount();
    	String orderId=o.getOrder_id();
    	int customerPhone=o.getCustomer_phone();
    	String customerName=o.getCustomer_name();
    	String customerEmail=o.getCustomer_email();

    	



        return cashfreeService.createOrder(orderId, amount, customerName, customerEmail, customerPhone+"");
    }
    @GetMapping("/directly")
    public String createorderdirectly(Booking b, User U)
    {
        return cashfreeService.createorderdirectly(b,U);
    }



    @GetMapping("/order-status")
    public String getOrderStatus(@RequestParam String orderId) {
        // Call the service to check the order status
        return cashfreeService.checkOrderStatus(orderId);
    }
}
