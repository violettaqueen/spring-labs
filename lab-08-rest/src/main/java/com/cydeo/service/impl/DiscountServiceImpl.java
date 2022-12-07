package com.cydeo.service.impl;

import com.cydeo.dto.DiscountDTO;
import com.cydeo.entity.Discount;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.DiscountRepository;
import com.cydeo.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepository discountRepository;
    private final MapperUtil mapperUtil;

    public DiscountServiceImpl(DiscountRepository discountRepository, MapperUtil mapperUtil) {
        this.discountRepository = discountRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public DiscountDTO getDiscountByName(String name) {
        Discount discount = discountRepository.findFirstByName(name);
        return mapperUtil.convert(discount, new DiscountDTO());
    }

    @Override
    public List<DiscountDTO> getDiscountList() {
        List<Discount> discountList = discountRepository.findAll();
        return discountList.stream()
                .map(discount -> mapperUtil.convert(discount, new DiscountDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public DiscountDTO save(DiscountDTO discountDTO) {
        Discount discountToSave = mapperUtil.convert(discountDTO, new Discount());
        discountRepository.save(discountToSave);
        return discountDTO;
    }

    @Override
    public DiscountDTO update(DiscountDTO discountDTO) {
        Discount discountToSave = mapperUtil.convert(discountDTO, new Discount());
        discountRepository.save(discountToSave);
        return discountDTO;

    }
}
