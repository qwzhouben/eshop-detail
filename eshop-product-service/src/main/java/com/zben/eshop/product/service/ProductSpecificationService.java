package com.zben.eshop.product.service;

import com.zben.eshop.product.model.ProductSpecification;

/**
 * @DESC:
 * @AUTHOR: zhouben
 * @DATE: 2019/10/25 0025 11:21
 */
public interface ProductSpecificationService {

    public void add(ProductSpecification product);

    public void update(ProductSpecification product);

    public void delete(Long id);

    public ProductSpecification findById(Long id);
}
