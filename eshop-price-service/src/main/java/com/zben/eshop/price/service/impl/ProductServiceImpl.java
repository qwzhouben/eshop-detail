package com.zben.eshop.price.service.impl;

import com.zben.eshop.price.model.ProductPrice;
import com.zben.eshop.price.mapper.ProductPriceMapper;
import com.zben.eshop.price.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:22
 */
@Service
public class ProductServiceImpl implements ProductPriceService {

    @Autowired
    ProductPriceMapper productPriceMapper;

    @Override
    public void add(ProductPrice productPrice) {
        productPriceMapper.add(productPrice);
    }

    @Override
    public void update(ProductPrice productPrice) {
        productPriceMapper.update(productPrice);
    }

    @Override
    public void delete(Long id) {
        productPriceMapper.delete(id);
    }

    @Override
    public ProductPrice findById(Long id) {
        return productPriceMapper.findById(id);
    }
}
