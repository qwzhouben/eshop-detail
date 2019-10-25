package com.zben.eshop.price.mapper;

import com.zben.eshop.price.model.ProductPrice;
import org.apache.ibatis.annotations.*;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:15
 */
@Mapper
public interface ProductPriceMapper {

    @Insert("INSERT INTO product_price(price, product_id) VALUES(#{price}, #{productId})")
    public void add(ProductPrice productPrice);

    @Update("UPDATE product_price SET price=#{price} WHERE id=#{id}")
    public void update(ProductPrice productPrice);

    @Delete("DELETE FROM product_price WHERE id=#{id}")
    public void delete(@Param("id") Long id);

    @Select("SELECT id, ROUND(price,2) as price, product_id FROM product_price WHERE id=#{id}")
    @Results(@Result(column = "product_id", property = "productId"))
    public ProductPrice findById(@Param("id") Long id);
}
