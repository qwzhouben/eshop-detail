package com.zben.eshop.product.controller;

import com.zben.eshop.product.model.Category;
import com.zben.eshop.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:24
 */
@RestController
@RequestMapping("/cate")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/add")
    public String add(Category category) {
        try {
            categoryService.add(category);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/update")
    public String update(Category category) {
        try {
            categoryService.update(category);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        try {
            categoryService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/select/{id}")
    public Category select(@PathVariable("id") Long id) {
        return categoryService.findById(id);
    }
}
