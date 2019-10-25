package com.zben.eshop.product.controller;

import com.zben.eshop.product.model.Brand;
import com.zben.eshop.product.model.Category;
import com.zben.eshop.product.service.BrandService;
import com.zben.eshop.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:24
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping("/add")
    public String add(Brand brand) {
        try {
            brandService.add(brand);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/update")
    public String update(Brand brand) {
        try {
            brandService.update(brand);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        try {
            brandService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/select/{id}")
    public Brand select(@PathVariable("id") Long id) {
        return brandService.findById(id);
    }
}
