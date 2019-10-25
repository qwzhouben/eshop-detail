package com.zben.eshop.inventory.mapper;

import com.zben.eshop.inventory.model.ProductInventory;
import org.apache.ibatis.annotations.*;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:15
 */
@Mapper
public interface InventoryMapper {

    @Insert("INSERT INTO product_inventory(num, product_id) VALUES(#{num}, #{productId})")
    public void add(ProductInventory productInventory);

    @Update("UPDATE product_inventory SET num=#{num} WHERE id=#{id}")
    public void update(ProductInventory productInventory);

    @Delete("DELETE FROM product_inventory WHERE id=#{id}")
    public void delete(@Param("id") Long id);

    @Select("SELECT *  FROM product_inventory WHERE id=#{id}")
    @Results(@Result(column = "product_id", property = "productId"))
    public ProductInventory findById(@Param("id") Long id);
}
