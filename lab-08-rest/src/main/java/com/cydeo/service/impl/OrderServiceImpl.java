package com.cydeo.service.impl;

import com.cydeo.dto.OrderDTO;
import com.cydeo.entity.Order;
import com.cydeo.enums.PaymentMethod;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.OrderRepository;
import com.cydeo.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final MapperUtil mapperUtil;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(MapperUtil mapperUtil, OrderRepository orderRepository) {
        this.mapperUtil = mapperUtil;
        this.orderRepository = orderRepository;
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
        orderRepository.save(orderToUpdate);

        return orderDTO;
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order orderToCreate= mapperUtil.convert(orderDTO, new Order());
        Order order = orderRepository.save(orderToCreate);
        return orderDTO;
    }
}
