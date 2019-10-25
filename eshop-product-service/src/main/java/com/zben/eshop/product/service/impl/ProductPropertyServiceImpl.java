package com.zben.eshop.product.service.impl;

import com.zben.eshop.product.mapper.ProductPropertyMapper;
import com.zben.eshop.product.model.ProductProperty;
import com.zben.eshop.product.service.ProductPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:22
 */
@Service
public class ProductPropertyServiceImpl implements ProductPropertyService {

    @Autowired
    ProductPropertyMapper productPropertyMapper;

    @Override
    public void add(ProductProperty productProperty) {
        productPropertyMapper.add(productProperty);
    }

    @Override
    public void update(ProductProperty productProperty) {
        productPropertyMapper.update(productProperty);
    }

    @Override
    public void delete(Long id) {
        productPropertyMapper.delete(id);
    }

    @Override
    public ProductProperty findById(Long id) {
        return productPropertyMapper.findById(id);
    }
}
