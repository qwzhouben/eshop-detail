package com.zben.eshop.price.model;

import lombok.Data;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 14:51
 */
@Data
public class ProductPrice {

    private Long id;

    private String price;

    private Long productId;
}
