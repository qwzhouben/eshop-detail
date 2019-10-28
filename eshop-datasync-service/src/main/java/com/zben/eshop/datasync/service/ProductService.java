package com.zben.eshop.datasync.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/28 0028 10:15
 */
@FeignClient(value = "eshop-product-service")
public interface ProductService {

    @GetMapping("/brand/select/{id}")
    String findBrandById(@PathVariable("id") Long id);

    @GetMapping("/category/select/{id}")
    String findCategoryById(@PathVariable("id") Long id);

    @GetMapping("/product-intro/select/{id}")
    String findProductIntroById(@PathVariable( "id") Long id);

    @GetMapping("/product-property/select/{id}")
    String findProductPropertyById(@PathVariable("id") Long id);

    @GetMapping("/product/select/{id}")
    String findProductById(@PathVariable("id") Long id);

    @GetMapping("/product-specification/select/{id}")
    String findProductSpecificationById(@PathVariable("id") Long id);
}
