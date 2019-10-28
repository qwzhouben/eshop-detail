package com.zben.eshop.product.service.impl;

import com.zben.eshop.product.mapper.CategoryMapper;
import com.zben.eshop.product.model.Category;
import com.zben.eshop.product.rabbitmq.RabbitMQSender;
import com.zben.eshop.product.rabbitmq.RabbitQueue;
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
    @Autowired
    RabbitMQSender rabbitMQSender;

    @Override
    public void add(Category category) {
        int id = categoryMapper.add(category);
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"add\", \"data_type\":\"category\", \"id\":"+id+"}");
    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"update\", \"data_type\":\"category\", \"id\":"+category.getId()+"}");
    }

    @Override
    public void delete(Long id) {
        categoryMapper.delete(id);
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"delete\", \"data_type\":\"category\", \"id\":"+id+"}");
    }

    @Override
    public Category findById(Long id) {
        return categoryMapper.findById(id);
    }
}
