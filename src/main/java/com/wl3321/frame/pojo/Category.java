package com.wl3321.frame.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * author : WYH
 * e-mail : wenyuhang@qinjia001.com
 * date   : 2020/8/19 13:55
 * desc   :
 */
@Getter
@Setter
public class Category {
    private int id;
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<Product> products;
}
