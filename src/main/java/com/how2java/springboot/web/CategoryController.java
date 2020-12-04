/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CategoryController
 * Author:   苏晨宇
 * Date:     2020/12/3 20:55
 * Description: 控制器 crud一套安排
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.springboot.web;

import com.how2java.springboot.dao.CategoryDAO;
import com.how2java.springboot.pojo.Category;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈控制器 crud一套安排〉
 *
 * @author 苏晨宇
 * @create 2020/12/3
 * @since 1.0.0
 */
@Controller
public class CategoryController {
    @Autowired
    CategoryDAO categoryDAO;

    //每页数量
    @GetMapping("/listCategory")
    public String listCategory(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) {
        String query = "商品";//查询条件
        SearchQuery searchQuery = getEntitySearchQuery(start, size, query);
        Page<Category> page = categoryDAO.search(searchQuery);
        m.addAttribute("page", page);
        return "listCategory";
    }

    private SearchQuery getEntitySearchQuery(int start, int size, String searchContent) {
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
                .add(QueryBuilders.matchAllQuery(),
                        ScoreFunctionBuilders.weightFactorFunction(100))
                .scoreMode("sum")
                .setMinScore(10);

        //设置分页
        //Sort sort = new Sort(Sort.Direction.DESC, "id");
        //Pageable pageable = new PageRequest(start, size, sort);
        Pageable pageable = new PageRequest(start, size);

        return new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();
    }

    @RequestMapping("/addCategory")
    public String addCategory(Category c) {
        int id = currentTime();
        c.setId(id);
        categoryDAO.save(c);
        return "redirect:listCategory";
    }

    private int currentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
        String time = sdf.format(new Date());
        return Integer.parseInt(time);
    }

    @RequestMapping("/deleteCategory")
    public String deleteCategory(Category c) {
        categoryDAO.delete(c);
        return "redirect:listCategory";
    }

    @RequestMapping("/updateCategory")
    public String updateCategory(Category c) {
        categoryDAO.save(c);
        return "redirect:listCategory";
    }

    @RequestMapping("/editCategory")
    public String editCategory(int id, Model m) {
        Category c = categoryDAO.findOne(id);
        m.addAttribute("c", c);
        return "editCategory";
    }


}
 
