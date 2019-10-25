package com.zben.eshop.product.service.impl;

import com.zben.eshop.product.mapper.ProductSpecificationMapper;
import com.zben.eshop.product.model.ProductSpecification;
import com.zben.eshop.product.service.ProductSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:22
 */
@Service
public class ProductSpecificationServiceImpl implements ProductSpecificationService {

    @Autowired
    ProductSpecificationMapper productSpecificationMapper;

    @Override
    public void add(ProductSpecification productSpecification) {
        productSpecificationMapper.add(productSpecification);
    }

    @Override
    public void update(ProductSpecification productSpecification) {
        productSpecificationMapper.update(productSpecification);
    }

    @Override
    public void delete(Long id) {
        productSpecificationMapper.delete(id);
    }

    @Override
    public ProductSpecification findById(Long id) {
        return productSpecificationMapper.findById(id);
    }
}
