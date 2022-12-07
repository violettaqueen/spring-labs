package com.cydeo.service;

import com.cydeo.dto.DiscountDTO;

import java.util.List;

public interface DiscountService {

    DiscountDTO getDiscountByName(String name);
    List<DiscountDTO> getDiscountList();
    DiscountDTO save(DiscountDTO discountDTO);
    DiscountDTO update(DiscountDTO discountDTO);
}
