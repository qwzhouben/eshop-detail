package com.zben.eshop.product.service.impl;

import com.zben.eshop.product.mapper.ProductIntroMapper;
import com.zben.eshop.product.mapper.ProductMapper;
import com.zben.eshop.product.model.Product;
import com.zben.eshop.product.model.ProductIntro;
import com.zben.eshop.product.rabbitmq.RabbitMQSender;
import com.zben.eshop.product.rabbitmq.RabbitQueue;
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
    @Autowired
    RabbitMQSender rabbitMQSender;

    @Override
    public void add(ProductIntro productIntro) {
        productIntroMapper.add(productIntro);
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"add\", \"data_type\":\"intro\", \"id\":"+productIntro.getId()+"}");
    }

    @Override
    public void update(ProductIntro productIntro) {
        productIntroMapper.update(productIntro);
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"update\", \"data_type\":\"intro\", \"id\":"+productIntro.getId()+"}");
    }

    @Override
    public void delete(Long id) {
        productIntroMapper.delete(id);
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"add\", \"data_type\":\"intro\", \"id\":"+id+"}");
    }

    @Override
    public ProductIntro findById(Long id) {
        return productIntroMapper.findById(id);
    }
}
