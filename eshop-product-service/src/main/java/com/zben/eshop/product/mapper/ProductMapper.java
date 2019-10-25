package com.zben.eshop.product.mapper;

import com.zben.eshop.product.model.Product;
import org.apache.ibatis.annotations.*;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:15
 */
@Mapper
public interface ProductMapper {

    @Insert("INSERT INTO product(name, category_id, brand_id) VALUES(#{name}, #{categoryId}, #{brandId})")
    public void add(Product product);

    @Update("UPDATE product SET name=#{name} WHERE id=#{id}")
    public void update(Product product);

    @Delete("DELETE FROM product WHERE id=#{id}")
    public void delete(@Param("id") Long id);

    @Select("SELECT * FROM product WHERE id=#{id}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "brand_id", property = "brandId")
    }
    )
    public Product findById(@Param("id") Long id);
}
