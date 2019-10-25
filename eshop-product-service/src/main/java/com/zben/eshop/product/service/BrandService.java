package com.zben.eshop.product.service;

import com.zben.eshop.product.model.Brand;

/**
 * @DESC:
 * @AUTHOR: zhouben
 * @DATE: 2019/10/25 0025 11:21
 */
public interface BrandService {

    public void add(Brand brand);

    public void update(Brand brand);

    public void delete(Long id);

    public Brand findById(Long id);
}
