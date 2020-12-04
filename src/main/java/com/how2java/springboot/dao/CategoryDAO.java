/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CategoryDAO
 * Author:   苏晨宇
 * Date:     2020/12/3 20:53
 * Description: CRUD操作
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.springboot.dao;

import com.how2java.springboot.pojo.Category;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 〈一句话功能简述〉<br> 
 * 〈CRUD操作〉
 *
 * @author 苏晨宇
 * @create 2020/12/3
 * @since 1.0.0
 */
public interface CategoryDAO extends ElasticsearchRepository<Category,Integer> {

}
 
