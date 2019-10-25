package com.zben.eshop.product.service;

import com.zben.eshop.product.model.ProductIntro;

/**
 * @DESC:
 * @AUTHOR: zhouben
 * @DATE: 2019/10/25 0025 11:21
 */
public interface ProductIntroService {

    public void add(ProductIntro product);

    public void update(ProductIntro product);

    public void delete(Long id);

    public ProductIntro findById(Long id);
}
