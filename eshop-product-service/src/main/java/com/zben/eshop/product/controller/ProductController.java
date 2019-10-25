package com.zben.eshop.product.controller;

import com.zben.eshop.product.model.Product;
import com.zben.eshop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:24
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/add")
    public String add(Product product) {
        try {
            productService.add(product);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/update")
    public String update(Product product) {
        try {
            productService.update(product);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        try {
            productService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/select/{id}")
    public Product select(@PathVariable("id") Long id) {
        return productService.findById(id);
    }
}
