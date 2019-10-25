package com.zben.eshop.product.controller;

import com.zben.eshop.product.model.ProductSpecification;
import com.zben.eshop.product.service.ProductSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @DESC: 商品规格controller
 * @author: zhouben
 * @date: 2019/10/25 0025 11:24
 */
@RestController
@RequestMapping("/product-specification")
public class ProductSpecificationController {

    @Autowired
    ProductSpecificationService productSpecificationService;

    @GetMapping("/add")
    public String add(ProductSpecification productSpecification) {
        try {
            productSpecificationService.add(productSpecification);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/update")
    public String update(ProductSpecification productSpecification) {
        try {
            productSpecificationService.update(productSpecification);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        try {
            productSpecificationService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/select/{id}")
    public ProductSpecification select(@PathVariable("id") Long id) {
        return productSpecificationService.findById(id);
    }
}
