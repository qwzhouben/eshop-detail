package com.zben.eshop.inventory.model;

import lombok.Data;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 14:51
 */
@Data
public class ProductInventory {

    private Long id;

    private String num;

    private Long productId;
}
