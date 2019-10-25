package com.zben.eshop.price.controller;

import com.zben.eshop.price.model.ProductPrice;
import com.zben.eshop.price.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @DESC: 价格controller
 * @author: zhouben
 * @date: 2019/10/25 0025 11:24
 */
@RestController
@RequestMapping("/price")
public class ProductPriceController {

    @Autowired
    ProductPriceService productPriceService;

    @GetMapping("/add")
    public String add(ProductPrice productPrice) {
        try {
            productPriceService.add(productPrice);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/update")
    public String update(ProductPrice productPrice) {
        try {
            productPriceService.update(productPrice);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        try {
            productPriceService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/select/{id}")
    public ProductPrice select(@PathVariable("id") Long id) {
        return productPriceService.findById(id);
    }
}
