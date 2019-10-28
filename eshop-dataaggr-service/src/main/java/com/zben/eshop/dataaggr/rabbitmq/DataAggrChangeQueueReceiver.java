package com.zben.eshop.dataaggr.rabbitmq;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/28 0028 11:27
 */
@Component
@RabbitListener(queues = "aggr-data-change-queue")
public class DataAggrChangeQueueReceiver {

    @Autowired
    Jedis jedis;

    @RabbitHandler
    public void process(String message) {
        JSONObject jsonObject = JSONObject.parseObject(message);
        String dimType = jsonObject.getString("dim_type");
        if ("brand".equals(dimType)) {
            processBrandDimDataChange(jsonObject);
        } else if("category".equals(dimType)) {
            processCategoryDimDataChange(jsonObject);
        } else if("product_intro".equals(dimType)) {
            processProductIntroDimDataChange(jsonObject);
        } else if("product".equals(dimType)) {
            processProductDimDataChange(jsonObject);
        }
    }

    private void processBrandDimDataChange(JSONObject jsonObject) {
        Long id = jsonObject.getLong("id");
        String dataJson = jedis.get("brand_" + id);
        // 多此一举，看一下，查出来一个品牌数据，然后直接就原样写redis
        // 实际上是这样子的，我们这里是简化了数据结构和业务，实际上任何一个维度数据都不可能只有一个原子数据
        // 品牌数据，肯定是结构多变的，结构比较复杂，有很多不同的表，不同的原子数据
        // 实际上这里肯定是要将一个品牌对应的多个原子数据都从redis查询出来，然后聚合之后写入redis
        if (!StringUtils.isEmpty(dataJson)) {
            jedis.set("dim_brand_" + id, dataJson);
        } else {
            jedis.del("dim_brand_" + id);
        }
    }

    private void processCategoryDimDataChange(JSONObject jsonObject) {
        Long id = jsonObject.getLong("id");
        String dataJson = jedis.get("category_" + id);

        if (!StringUtils.isEmpty(dataJson)) {
            jedis.set("dim_category_" + id, dataJson);
        } else {
            jedis.del("dim_category_" + id);
        }
    }

    private void processProductIntroDimDataChange(JSONObject messageJSONObject) {
        Long id = messageJSONObject.getLong("id");

        String dataJSON = jedis.get("product_intro_" + id);

        if(dataJSON != null && !"".equals(dataJSON)) {
            jedis.set("dim_product_intro_" + id, dataJSON);
        } else {
            jedis.del("dim_product_intro_" + id);
        }
    }

    private void processProductDimDataChange(JSONObject messageJSONObject) {
        Long id = messageJSONObject.getLong("id");

        String dataJSON = jedis.get("product_" + id);
        if (!StringUtils.isEmpty(dataJSON)) {
            JSONObject productDataJSONObject = JSONObject.parseObject(dataJSON);
            String propertyJson = jedis.get("product_property_" + id);
            if (!StringUtils.isEmpty(propertyJson)) {
                productDataJSONObject.put("product_property", JSONObject.parse(propertyJson));
            }
            String specificationJson = jedis.get("product_specification_" + id);
            if (!StringUtils.isEmpty(specificationJson)) {
                productDataJSONObject.put("product_specification", JSONObject.parse(specificationJson));
            }
            jedis.set("dim_product_" + id, productDataJSONObject.toJSONString());
        } else {
            jedis.del("product_" + id);
        }
    }
}
