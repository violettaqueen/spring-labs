package com.cydeo.service.impl;

import com.cydeo.dto.PaymentDTO;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.PaymentRepository;
import com.cydeo.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final MapperUtil mapperUtil;

    public PaymentServiceImpl(PaymentRepository paymentRepository, MapperUtil mapperUtil) {
        this.paymentRepository = paymentRepository;
        this.mapperUtil = mapperUtil;
    }


    @Override
    public PaymentDTO findById(Long id) {
        return mapperUtil.convert(paymentRepository.findById(id), new PaymentDTO());
    }
}
