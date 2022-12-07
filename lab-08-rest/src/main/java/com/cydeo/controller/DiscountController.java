package com.cydeo.controller;

import com.cydeo.dto.DiscountDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.DiscountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/discount")
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getDiscountList() {
        List<DiscountDTO> discountDTOList = discountService.getDiscountList();
        return ResponseEntity.ok(new ResponseWrapper("Discount list is successfully retrieved", discountDTOList, HttpStatus.OK));

    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createDiscount(@RequestBody DiscountDTO discountDTO) {
        discountService.save(discountDTO);
        return ResponseEntity.ok(new ResponseWrapper("Discount is successfully created", discountService.save(discountDTO), HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateDiscount(@RequestBody DiscountDTO discountDTO) {
        discountService.update(discountDTO);
        return ResponseEntity.ok(new ResponseWrapper("Discount is successfully updated", discountService.update(discountDTO), HttpStatus.OK));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> getDiscountByName(@PathVariable("name") String name) {
        DiscountDTO discountDTO = discountService.getDiscountByName(name);
        return ResponseEntity.ok(new ResponseWrapper("Discount by name is successfully retrieved", discountDTO, HttpStatus.OK));
    }
}