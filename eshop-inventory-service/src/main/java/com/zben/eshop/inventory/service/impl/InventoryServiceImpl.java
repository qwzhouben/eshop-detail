package com.zben.eshop.inventory.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zben.eshop.inventory.mapper.InventoryMapper;
import com.zben.eshop.inventory.model.ProductInventory;
import com.zben.eshop.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:22
 */
@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryMapper inventoryMapper;
    @Autowired
    Jedis jedis;

    @Override
    public void add(ProductInventory productInventory) {
        inventoryMapper.add(productInventory);
        jedis.set("product_inventory_" + productInventory.getProductId(), JSONObject.toJSONString(productInventory));
    }

    @Override
    public void update(ProductInventory productInventory) {
        inventoryMapper.update(productInventory);
        jedis.set("product_inventory_" + productInventory.getProductId(), JSONObject.toJSONString(productInventory));
    }

    @Override
    public void delete(Long id) {
        ProductInventory productInventory = inventoryMapper.findById(id);
        inventoryMapper.delete(id);
        jedis.del("product_inventory_" + productInventory.getProductId());
    }

    @Override
    public ProductInventory findById(Long id) {
        return inventoryMapper.findById(id);
    }
}
