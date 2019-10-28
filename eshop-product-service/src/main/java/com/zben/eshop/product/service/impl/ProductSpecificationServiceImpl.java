package com.zben.eshop.product.service.impl;

import com.zben.eshop.product.mapper.ProductSpecificationMapper;
import com.zben.eshop.product.model.ProductSpecification;
import com.zben.eshop.product.rabbitmq.RabbitMQSender;
import com.zben.eshop.product.rabbitmq.RabbitQueue;
import com.zben.eshop.product.service.ProductSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:22
 */
@Service
public class ProductSpecificationServiceImpl implements ProductSpecificationService {

    @Autowired
    ProductSpecificationMapper productSpecificationMapper;
    @Autowired
    RabbitMQSender rabbitMQSender;

    @Override
    public void add(ProductSpecification productSpecification) {
        productSpecificationMapper.add(productSpecification);
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"add\", \"data_type\":\"specification\", \"id\":"+productSpecification.getId()+",\"product_id\":"+productSpecification.getProductId()+"}");
    }

    @Override
    public void update(ProductSpecification productSpecification) {
        productSpecificationMapper.update(productSpecification);
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"update\", \"data_type\":\"specification\", \"id\":"+productSpecification.getId()+",\"product_id\":"+productSpecification.getProductId()+"}");
    }

    @Override
    public void delete(Long id) {
        ProductSpecification productSpecification = findById(id);
        productSpecificationMapper.delete(id);
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"delete\", \"data_type\":\"specification\", \"id\":"+id+",\"product_id\":"+productSpecification.getProductId()+"}");
    }

    @Override
    public ProductSpecification findById(Long id) {
        return productSpecificationMapper.findById(id);
    }
}
