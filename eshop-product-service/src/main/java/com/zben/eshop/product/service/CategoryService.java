package com.zben.eshop.product.service;

import com.zben.eshop.product.model.Category;

/**
 * @DESC:
 * @AUTHOR: zhouben
 * @DATE: 2019/10/25 0025 11:21
 */
public interface CategoryService {

    public void add(Category category);

    public void update(Category category);

    public void delete(Long id);

    public Category findById(Long id);
}
