package com.zben.eshop.product.controller;

import com.zben.eshop.product.model.ProductIntro;
import com.zben.eshop.product.service.ProductIntroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @DESC: 商品介绍controller
 * @author: zhouben
 * @date: 2019/10/25 0025 11:24
 */
@RestController
@RequestMapping("/product-intro")
public class ProductIntroController {

    @Autowired
    ProductIntroService productIntroService;

    @GetMapping("/add")
    public String add(ProductIntro productIntro) {
        try {
            productIntroService.add(productIntro);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/update")
    public String update(ProductIntro productIntro) {
        try {
            productIntroService.update(productIntro);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        try {
            productIntroService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/select/{id}")
    public ProductIntro select(@PathVariable("id") Long id) {
        return productIntroService.findById(id);
    }
}
