package com.yxr.tmall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yxr.tmall.commonUtils.R;
import com.yxr.tmall.entity.Category;
import com.yxr.tmall.entity.Product;
import com.yxr.tmall.mapper.CategoryMapper;
import com.yxr.tmall.mapper.ProductMapper;
import com.yxr.tmall.service.CategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liqiqiorz
 * @since 2020-08-08
 */
@RestController
@RequestMapping("/tmall/category")
public class CategoryController {


@Autowired
private CategoryMapper categoryMapper;
    @Autowired
    private CategoryService categoryService;
//default
//返回所有category
    @GetMapping("/categories")
    @Cacheable(key = "'list'",value = "lists")
    public R list(){
        List<Category> list=categoryService.list(null);
        return R.ok().data("list",list);
    }

    @GetMapping("/categories/1")
    @Cacheable(key = "'list'",value = "lists")
    public List<Category> lists(){
        List<Category> list=categoryService.list(null);
        return list;
    }



//    default
//分页加多条件查询:1配插件 educonfig 2写方法
    @GetMapping("/categories/{current}/{limit}")
    public R pageListcategories(@PathVariable long current,
                                @PathVariable long limit){
        Page<Category> pageCategories = new Page<>(current, limit);
//        框架把所有数据封装到pageCatgegories
        categoryService.page(pageCategories,null);
//        总记录数
        long total=pageCategories.getTotal();
//        数据的list集合
        List<Category> records=pageCategories.getRecords();
        return R.ok().data("total",total).data("rows",records);
//        以上方法等同于
        //        Map map=new HashMap();
//        map.put("total",total);
//        map.put("rows",records);
//        return R.ok().data(map);   这个方法也可以，因为data有map封装，也有key value封装

    }
//    多条件带分页功能
    @PostMapping("categoriesCondition/{current}/{limit}")
    public R pageCategoriesCondition(@PathVariable long current,
                                     @PathVariable long limit,
                                     @RequestBody(required = false) Category category){
        Page<Category> pageCategories =new Page<>(current,limit);
//      构建条件
        QueryWrapper<Category> wrapper=new QueryWrapper<>();
//        多条件组合查询,用判断拼接sql
        Integer id = category.getId();
        String name = category.getName();
        if (id!=0){
            wrapper.ge("id",id);
        }
        if (!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
//        对id进行排序
        wrapper.orderByDesc("id");
        categoryService.page(pageCategories,wrapper);
        long total=pageCategories.getTotal();
//        数据的list集合
        List<Category> records=pageCategories.getRecords();
        return R.ok().data("total",total).data("rows",records);
    }
//default
//    添加分类的方法
    @PostMapping("addCategory")
    public R addCategory(@RequestBody Category category){
        boolean save = categoryService.save(category);
        if (save){
            return R.ok();
        }else {
            return R.error();
        }
    }

//    修改分类: 1.查询分类回显 2.修改
    @GetMapping("getCategory/{id}")
    public R getCategory(@PathVariable String id){
        Category byId = categoryService.getById(id);
        return R.ok().data("category",byId);
    }
//修改,一般来说用put提交,但是参数是@requBody
    @PostMapping R updateCategory(@RequestBody Category category) {
        boolean b = categoryService.updateById(category);
    if(b){
        return R.ok();
    }else {
        return R.error();
    }

    }

    @GetMapping("products/{id}")
    public R CProducts(@PathVariable String id){
        Category category = categoryService.getById(id);
        int i = Integer.parseInt(id);
        List<Product> products = categoryMapper.searchProductsByCategoryId(i);
        category.setProducts(products);
        return R.ok().data("category",category);
    }

    @GetMapping("getCategorys/{id}")
    public R getCategorys(@PathVariable String id){
        Category category = categoryService.getById(id);
        return R.ok().data("category",category);
    }

}

