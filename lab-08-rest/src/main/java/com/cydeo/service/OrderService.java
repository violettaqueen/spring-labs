package com.cydeo.service;

import com.cydeo.dto.OrderDTO;
import com.cydeo.enums.PaymentMethod;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService {

    List<OrderDTO> getAllOrders();
    List<OrderDTO> getOrderListByPaymentMethod(PaymentMethod paymentMethod);
    List<OrderDTO> getOrderListByEmail(String email);
    OrderDTO updateOrder(OrderDTO orderDTO);
    OrderDTO createOrder(OrderDTO orderDTO);


}
