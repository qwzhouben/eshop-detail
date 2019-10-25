package com.zben.eshop.price.service;

import com.zben.eshop.price.model.ProductPrice;

/**
 * @DESC:
 * @AUTHOR: zhouben
 * @DATE: 2019/10/25 0025 11:21
 */
public interface ProductPriceService {

    public void add(ProductPrice productPrice);

    public void update(ProductPrice productPrice);

    public void delete(Long id);

    public ProductPrice findById(Long id);
}
