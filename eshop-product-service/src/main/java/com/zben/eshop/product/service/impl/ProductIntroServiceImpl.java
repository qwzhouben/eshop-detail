package com.zben.eshop.product.service.impl;

import com.zben.eshop.product.mapper.ProductIntroMapper;
import com.zben.eshop.product.mapper.ProductMapper;
import com.zben.eshop.product.model.Product;
import com.zben.eshop.product.model.ProductIntro;
import com.zben.eshop.product.service.ProductIntroService;
import com.zben.eshop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:22
 */
@Service
public class ProductIntroServiceImpl implements ProductIntroService {

    @Autowired
    ProductIntroMapper productIntroMapper;

    @Override
    public void add(ProductIntro productIntro) {
        productIntroMapper.add(productIntro);
    }

    @Override
    public void update(ProductIntro productIntro) {
        productIntroMapper.update(productIntro);
    }

    @Override
    public void delete(Long id) {
        productIntroMapper.delete(id);
    }

    @Override
    public ProductIntro findById(Long id) {
        return productIntroMapper.findById(id);
    }
}
