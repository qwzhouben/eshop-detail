package com.zben.eshop.product.mapper;

import com.zben.eshop.product.model.Brand;
import com.zben.eshop.product.model.Category;
import org.apache.ibatis.annotations.*;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:15
 */
@Mapper
public interface BrandMapper {

    @Insert("INSERT INTO brand(name, description) VALUES(#{name}, #{description})")
    public void add(Brand category);

    @Update("UPDATE brand SET name=#{name}, description=#{description} WHERE id=#{id}")
    public void update(Brand category);

    @Delete("DELETE FROM brand WHERE id=#{id}")
    public void delete(@Param("id") Long id);

    @Select("SELECT * FROM brand WHERE id=#{id}")
    public Brand findById(@Param("id") Long id);
}
