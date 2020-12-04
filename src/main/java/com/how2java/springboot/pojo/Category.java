/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Category
 * Author:   苏晨宇
 * Date:     2020/12/3 20:52
 * Description: 实体类，连接到ES上
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.springboot.pojo;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * 〈一句话功能简述〉<br>
 * 〈实体类，连接到ES上〉
 *
 * @author 苏晨宇
 * @create 2020/12/3
 * @since 1.0.0
 */
@Document(indexName = "how2java", type = "category")
public class Category {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
 
