package com.zben.eshop.inventory.service;

import com.zben.eshop.inventory.model.ProductInventory;

/**
 * @DESC:
 * @AUTHOR: zhouben
 * @DATE: 2019/10/25 0025 11:21
 */
public interface InventoryService {

    public void add(ProductInventory productInventory);

    public void update(ProductInventory productInventory);

    public void delete(Long id);

    public ProductInventory findById(Long id);
}
