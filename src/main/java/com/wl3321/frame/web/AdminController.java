package com.wl3321.frame.web;

import com.wl3321.frame.mapper.CategoryMapper;
import com.wl3321.frame.mapper.ProductMapper;
import com.wl3321.frame.pojo.Bean;
import com.wl3321.frame.pojo.Category;
import com.wl3321.frame.pojo.Product;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * author : WYH
 * e-mail : wenyuhang@qinjia001.com
 * date   : 2020/8/19 11:55
 * desc   :
 */
@RestController
@Validated
public class AdminController {

    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    ProductMapper productMapper;

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello world";
    }

    @RequestMapping(value = "/getlist")
    public List<Category> admin(){
        List<Category> list = categoryMapper.getlist();
//        return categoryMapper.get(60);
        return list;
    }

    @RequestMapping(value = "/getProducts")
    public List<Product> test(){
        List<Product> list = productMapper.list();
        return list;
    }

    @RequestMapping(value = "/getPageCategory")
    public List<Category> getPage(){
        List<Category> categories = categoryMapper.listByPage(0, 5);
        return categories;
    }

    @GetMapping("/getUser")
    public String getUserStr(@NotBlank(message = "name 不能为空") String name,
                             @NotBlank(message = "age 不能为空")@Max(value = 99, message = "不能大于99岁") String age) {
        return "name: " + name + " ,age:" + age;
    }

    @PostMapping("/addUser")
    public String getUserStr(@Validated @RequestBody Bean user) {
        return "name: " + user.getName() + ", age:" + user.getSex();
    }
}
