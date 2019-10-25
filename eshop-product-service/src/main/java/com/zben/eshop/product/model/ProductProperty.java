package com.zben.eshop.product.model;

import lombok.Data;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:07
 */
@Data
public class ProductProperty {

    private Long id;

    private String name;

    private String values;

    private Long productId;

}
