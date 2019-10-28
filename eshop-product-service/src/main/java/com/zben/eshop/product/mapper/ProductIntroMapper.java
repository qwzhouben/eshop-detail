package com.zben.eshop.product.mapper;

import com.zben.eshop.product.model.ProductIntro;
import org.apache.ibatis.annotations.*;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:15
 */
@Mapper
public interface ProductIntroMapper {

    @Insert("INSERT INTO product_intro(content, product_id) VALUES(#{content}, #{productId})")
    public void add(ProductIntro product);

    @Update("UPDATE product_intro SET content=#{content} WHERE id=#{id}")
    public void update(ProductIntro product);

    @Delete("DELETE FROM product_intro WHERE id=#{id}")
    public void delete(@Param("id") Long id);

    @Select("SELECT * FROM product_intro WHERE id=#{id}")
    @Results({
            @Result(column = "product_id", property = "productId"),
        }
    )
    public ProductIntro findById(@Param("id") Long id);
}
