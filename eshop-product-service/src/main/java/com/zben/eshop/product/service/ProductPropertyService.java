package com.zben.eshop.product.service;

import com.zben.eshop.product.model.ProductProperty;

/**
 * @DESC:
 * @AUTHOR: zhouben
 * @DATE: 2019/10/25 0025 11:21
 */
public interface ProductPropertyService {

    public void add(ProductProperty product);

    public void update(ProductProperty product);

    public void delete(Long id);

    public ProductProperty findById(Long id);
}
