package com.zben.eshop.product.mapper;

import com.zben.eshop.product.model.ProductSpecification;
import org.apache.ibatis.annotations.*;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:15
 */
@Mapper
public interface ProductSpecificationMapper {

    @Insert("INSERT INTO product_specification(name, `values`, product_id) VALUES(#{name}, #{values}, #{productId})")
    public void add(ProductSpecification product);

    @Update("UPDATE product_specification SET name=#{name} WHERE id=#{id}")
    public void update(ProductSpecification product);

    @Delete("DELETE FROM product_specification WHERE id=#{id}")
    public void delete(@Param("id") Long id);

    @Select("SELECT * FROM product_specification WHERE id=#{id}")
    @Results({
            @Result(column = "product_id", property = "productId"),
        }
    )
    public ProductSpecification findById(@Param("id") Long id);
}
