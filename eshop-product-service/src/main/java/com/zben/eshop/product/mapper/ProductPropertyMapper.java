package com.zben.eshop.product.mapper;

import com.zben.eshop.product.model.ProductProperty;
import org.apache.ibatis.annotations.*;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:15
 */
@Mapper
public interface ProductPropertyMapper {

    @Insert("INSERT INTO product_property(name, `values`, product_id) VALUES(#{name}, #{values}, #{productId})")
    public void add(ProductProperty product);

    @Update("UPDATE product_property SET name=#{name}, `values`=#{values} WHERE id=#{id}")
    public void update(ProductProperty product);

    @Delete("DELETE FROM product_property WHERE id=#{id}")
    public void delete(@Param("id") Long id);

    @Select("SELECT * FROM product_property WHERE id=#{id}")
    @Results({
            @Result(column = "product_id", property = "productId"),
        }
    )
    public ProductProperty findById(@Param("id") Long id);
}
