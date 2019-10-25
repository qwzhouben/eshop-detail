package com.zben.eshop.product.controller;

import com.zben.eshop.product.model.ProductProperty;
import com.zben.eshop.product.service.ProductPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @DESC: 商品属性controller
 * @author: zhouben
 * @date: 2019/10/25 0025 11:24
 */
@RestController
@RequestMapping("/product-property")
public class ProductPropertyController {

    @Autowired
    ProductPropertyService productPropertyService;

    @GetMapping("/add")
    public String add(ProductProperty productProperty) {
        try {
            productPropertyService.add(productProperty);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/update")
    public String update(ProductProperty productProperty) {
        try {
            productPropertyService.update(productProperty);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        try {
            productPropertyService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/select/{id}")
    public ProductProperty select(@PathVariable("id") Long id) {
        return productPropertyService.findById(id);
    }
}
