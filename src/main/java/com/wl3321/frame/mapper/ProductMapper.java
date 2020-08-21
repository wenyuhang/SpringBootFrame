package com.wl3321.frame.mapper;

import com.wl3321.frame.pojo.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * author : WYH
 * e-mail : wenyuhang@qinjia001.com
 * date   : 2020/8/20 10:38
 * desc   :
 */
public interface ProductMapper {
    @Select(" select * from product where cid = #{cid}")
    public List<Product> listByCategory(int cid);

    @Select(" select * from product ")
//    @Results({
//            @Result(property="category",column="cid",one=@One(select="com.wl.mybatis.mapper.CategoryMapper.get"))
//    })
    public List<Product> list();
}
