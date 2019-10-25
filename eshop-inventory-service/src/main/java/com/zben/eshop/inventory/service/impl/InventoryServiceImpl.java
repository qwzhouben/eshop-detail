package com.zben.eshop.inventory.service.impl;

import com.zben.eshop.inventory.mapper.InventoryMapper;
import com.zben.eshop.inventory.model.ProductInventory;
import com.zben.eshop.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:22
 */
@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryMapper inventoryMapper;

    @Override
    public void add(ProductInventory productInventory) {
        inventoryMapper.add(productInventory);
    }

    @Override
    public void update(ProductInventory productInventory) {
        inventoryMapper.update(productInventory);
    }

    @Override
    public void delete(Long id) {
        inventoryMapper.delete(id);
    }

    @Override
    public ProductInventory findById(Long id) {
        return inventoryMapper.findById(id);
    }
}
