package com.zben.eshop.product.service;

import com.zben.eshop.product.model.Product;

/**
 * @DESC:
 * @AUTHOR: zhouben
 * @DATE: 2019/10/25 0025 11:21
 */
public interface ProductService {

    public void add(Product product);

    public void update(Product product);

    public void delete(Long id);

    public Product findById(Long id);
}
