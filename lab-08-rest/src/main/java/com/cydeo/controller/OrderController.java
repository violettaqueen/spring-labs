package com.cydeo.controller;

import com.cydeo.dto.OrderDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.enums.PaymentMethod;
import com.cydeo.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllOrders() {
        List<OrderDTO> orderDTOList = orderService.getAllOrders();
        return ResponseEntity.ok(new ResponseWrapper("Orders are successfully retrieved", orderDTOList, HttpStatus.OK));

    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO orderToUpdate = orderService.updateOrder(orderDTO);
        return ResponseEntity.ok(new ResponseWrapper("Orders are successfully retrieved", orderToUpdate, HttpStatus.OK));
    }
    @PostMapping
    public ResponseEntity<ResponseWrapper> createOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO orderToCreate = orderService.createOrder(orderDTO);
        return ResponseEntity.ok(new ResponseWrapper("Order is successfully created", orderToCreate, HttpStatus.OK));
    }
    @GetMapping("/paymentMethod/{paymentMethod}")
    public ResponseEntity<ResponseWrapper> getOrderListByPaymentMethod(@PathVariable("paymentMethod")PaymentMethod paymentMethod) {
        List<OrderDTO> orderDTOList = orderService.getOrderListByPaymentMethod(paymentMethod);
        return ResponseEntity.ok(new ResponseWrapper("Orders are successfully retrieved", orderDTOList, HttpStatus.OK));
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<ResponseWrapper> findAllByCustomer_Email(@PathVariable("email")String email) {
        List<OrderDTO> orderDTOList = orderService.getOrderListByEmail(email);
        return ResponseEntity.ok(new ResponseWrapper("Orders are successfully retrieved", orderDTOList, HttpStatus.OK));
    }

}