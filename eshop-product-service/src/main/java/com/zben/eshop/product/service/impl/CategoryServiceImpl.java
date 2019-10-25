package com.zben.eshop.product.service.impl;

import com.zben.eshop.product.mapper.CategoryMapper;
import com.zben.eshop.product.model.Category;
import com.zben.eshop.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:22
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public void add(Category category) {
        categoryMapper.add(category);
    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }

    @Override
    public void delete(Long id) {
        categoryMapper.delete(id);
    }

    @Override
    public Category findById(Long id) {
        return categoryMapper.findById(id);
    }
}
