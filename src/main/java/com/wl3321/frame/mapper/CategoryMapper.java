package com.wl3321.frame.mapper;

import com.wl3321.frame.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * author : WYH
 * e-mail : wenyuhang@qinjia001.com
 * date   : 2020/8/19 13:58
 * desc   :
 */
public interface CategoryMapper {
    @Insert(" insert into category ( name ) values (#{name}) ")
    public int add(Category category);

    @Delete(" delete from category where id= #{id} ")
    public void delete(int id);

    @Select("select * from category where id= #{id} ")
    public Category get(int id);

    @Update("update category set name=#{name} where id=#{id} ")
    public int update(Category category);

    @Select(" select * from category ")
    public List<Category> list();

    @Select(" select * from category ")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "products", javaType = List.class, column = "id", many = @Many(select = "com.wl.mybatis.mapper.ProductMapper.listByCategory") )
    })
    public List<Category> getlist();

    @Select("select * from category limit #{start},#{count}")
//    @Results({
//            @Result(property = "id", column = "id"),
//            @Result(property = "products", javaType = List.class, column = "id", many = @Many(select = "com.wl.mybatis.mapper.ProductMapper.listByCategory") )
//    })
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "products",javaType = List.class, column = "id",many = @Many(select = "com.wl.mybatis.mapper.ProductMapper.listByCategory") )
    })
    List<Category> listByPage(@Param("start") int start, @Param("count") int count);
}
