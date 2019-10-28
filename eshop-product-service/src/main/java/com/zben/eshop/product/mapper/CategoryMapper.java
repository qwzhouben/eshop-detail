package com.zben.eshop.product.mapper;

import com.zben.eshop.product.model.Category;
import org.apache.ibatis.annotations.*;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/10/25 0025 11:15
 */
@Mapper
public interface CategoryMapper {

    @Insert("INSERT INTO category(name, description) VALUES(#{name}, #{description})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int add(Category category);

    @Update("UPDATE category SET name=#{name}, description=#{description} WHERE id=#{id}")
    public void update(Category category);

    @Delete("DELETE FROM category WHERE id=#{id}")
    public void delete(@Param("id") Long id);

    @Select("SELECT * FROM category WHERE id=#{id}")
    public Category findById(@Param("id") Long id);
}
