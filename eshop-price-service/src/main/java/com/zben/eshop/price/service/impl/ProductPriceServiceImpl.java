package com.zben.eshop.price.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zben.eshop.price.model.ProductPrice;
import com.zben.eshop.price.mapper.ProductPriceMapper;
import com.zben.eshop.price.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:22
 */
@Service
public class ProductPriceServiceImpl implements ProductPriceService {

    @Autowired
    ProductPriceMapper productPriceMapper;
    @Autowired
    Jedis jedis;

    @Override
    public void add(ProductPrice productPrice) {
        productPriceMapper.add(productPrice);
        jedis.set("product_price_" + productPrice.getProductId(), JSONObject.toJSONString(productPrice));
    }

    @Override
    public void update(ProductPrice productPrice) {
        productPriceMapper.update(productPrice);
        jedis.set("product_price_" + productPrice.getProductId(), JSONObject.toJSONString(productPrice));
    }

    @Override
    public void delete(Long id) {
        ProductPrice productPrice = productPriceMapper.findById(id);
        productPriceMapper.delete(id);
        jedis.del("product_price_" + productPrice.getProductId());
    }

    @Override
    public ProductPrice findById(Long id) {
        return productPriceMapper.findById(id);
    }
}
