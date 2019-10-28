package com.zben.eshop.product.service.impl;

import com.zben.eshop.product.mapper.ProductPropertyMapper;
import com.zben.eshop.product.model.ProductProperty;
import com.zben.eshop.product.rabbitmq.RabbitMQSender;
import com.zben.eshop.product.rabbitmq.RabbitQueue;
import com.zben.eshop.product.service.ProductPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:22
 */
@Service
public class ProductPropertyServiceImpl implements ProductPropertyService {

    @Autowired
    ProductPropertyMapper productPropertyMapper;
    @Autowired
    RabbitMQSender rabbitMQSender;

    @Override
    public void add(ProductProperty productProperty) {
        productPropertyMapper.add(productProperty);
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"add\", \"data_type\":\"property\", \"id\":"+productProperty.getId()+",\"product_id\":"+productProperty.getProductId()+"}");
    }

    @Override
    public void update(ProductProperty productProperty) {
        productPropertyMapper.update(productProperty);
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"update\", \"data_type\":\"property\", \"id\":"+productProperty.getId()+",\"product_id\":"+productProperty.getProductId()+"}");
    }

    @Override
    public void delete(Long id) {
        ProductProperty productProperty = findById(id);
        productPropertyMapper.delete(id);
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"delete\", \"data_type\":\"property\", \"id\":"+id+",\"product_id\":"+productProperty.getProductId()+"}");
    }

    @Override
    public ProductProperty findById(Long id) {
        return productPropertyMapper.findById(id);
    }
}
