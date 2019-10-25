package com.zben.eshop.inventory.controller;

import com.zben.eshop.inventory.model.ProductInventory;
import com.zben.eshop.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @DESC: 库存controller
 * @author: zhouben
 * @date: 2019/10/25 0025 11:24
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping("/add")
    public String add(ProductInventory productInventory) {
        try {
            inventoryService.add(productInventory);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/update")
    public String update(ProductInventory productInventory) {
        try {
            inventoryService.update(productInventory);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        try {
            inventoryService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/select/{id}")
    public ProductInventory select(@PathVariable("id") Long id) {
        return inventoryService.findById(id);
    }
}
