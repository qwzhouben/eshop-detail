package com.zben.eshop.product.service.impl;

import com.zben.eshop.product.mapper.BrandMapper;
import com.zben.eshop.product.mapper.CategoryMapper;
import com.zben.eshop.product.model.Brand;
import com.zben.eshop.product.model.Category;
import com.zben.eshop.product.rabbitmq.RabbitMQSender;
import com.zben.eshop.product.rabbitmq.RabbitQueue;
import com.zben.eshop.product.service.BrandService;
import com.zben.eshop.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:22
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandMapper brandMapper;
    @Autowired
    RabbitMQSender rabbitMQSender;

    @Override
    public void add(Brand brand) {
        brandMapper.add(brand);
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"add\", \"data_type\":\"brand\", \"id\":"+brand.getId()+"}");
    }

    @Override
    public void update(Brand brand) {
        brandMapper.update(brand);
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"update\", \"data_type\":\"brand\", \"id\":"+brand.getId()+"}");
    }

    @Override
    public void delete(Long id) {
        brandMapper.delete(id);
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"delete\", \"data_type\":\"brand\", \"id\":"+id+"}");
    }

    @Override
    public Brand findById(Long id) {
        return brandMapper.findById(id);
    }
}
