package com.cydeo.service.impl;

import com.cydeo.dto.OrderDTO;
import com.cydeo.entity.Cart;
import com.cydeo.entity.Customer;
import com.cydeo.entity.Order;
import com.cydeo.entity.Payment;
import com.cydeo.enums.PaymentMethod;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.OrderRepository;
import com.cydeo.service.CartService;
import com.cydeo.service.CustomerService;
import com.cydeo.service.OrderService;
import com.cydeo.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final MapperUtil mapperUtil;
    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final PaymentService paymentService;
    private final CartService cartService;

    public OrderServiceImpl(MapperUtil mapperUtil, OrderRepository orderRepository, CustomerService customerService, PaymentService paymentService, CartService cartService) {
        this.mapperUtil = mapperUtil;
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.paymentService = paymentService;
        this.cartService = cartService;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> orderList = orderRepository.findAll();
        return orderList.stream()
                .map(order -> mapperUtil.convert(order, new OrderDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrderListByPaymentMethod(PaymentMethod paymentMethod) {
        List<Order> orderList = orderRepository.findAllByPayment_PaymentMethod(paymentMethod);
        return orderList.stream()
                .map(order -> mapperUtil.convert(order, new OrderDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrderListByEmail(String email) {
        List<Order> orderList = orderRepository.findAllByCustomer_Email(email);
        return orderList.stream()
                .map(order -> mapperUtil.convert(order, new OrderDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO) {
        Order orderToUpdate = mapperUtil.convert(orderDTO, new Order());

        orderToUpdate.setCustomer(mapperUtil.convert(customerService.findById(orderDTO.getCustomerId()), new Customer()));
        orderToUpdate.setPayment(mapperUtil.convert(paymentService.findById(orderDTO.getPaymentId()), new Payment()));
        orderToUpdate.setCart(mapperUtil.convert(cartService.findById(orderDTO.getCartId()), new Cart()));
        orderToUpdate.setPaidPrice(orderDTO.getPaidPrice());
        orderToUpdate.setTotalPrice(orderDTO.getTotalPrice());

        Order updatedOrder = orderRepository.save(orderToUpdate);

        return mapperUtil.convert(updatedOrder, new OrderDTO());
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {

        Order order = mapperUtil.convert(orderDTO, new Order());

        order.setCustomer(mapperUtil.convert(customerService.findById(orderDTO.getCustomerId()), new Customer()));
        order.setPayment(mapperUtil.convert(paymentService.findById(orderDTO.getPaymentId()), new Payment()));
        order.setCart(mapperUtil.convert(cartService.findById(orderDTO.getCartId()), new Cart()));
        order.setPaidPrice(orderDTO.getPaidPrice());
        order.setTotalPrice(orderDTO.getTotalPrice());

        Order updatedOrder = orderRepository.save(order);

        return mapperUtil.convert(updatedOrder, new OrderDTO());
    }
}