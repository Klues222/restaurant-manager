package com.web.dao;

import com.web.mapper.Category1Mapper;
import com.web.mapper.Category2Mapper;
import com.web.util.DBUtil;

import java.util.List;

public class Category1Dao {
//    通过类型模糊查询
    public List getByCname(String cname){
        return DBUtil.queryForList("select * from category_first where cname like ?", new Category1Mapper() , "%"+cname+"%");
    }
    public List getByCid(int cid){
        return DBUtil.queryForList("select * from category_first where cId = ?",new Category1Mapper(),cid);
    }
//    得到所有一级商品内容
    public List getAll(){
        return DBUtil.queryForList("select * from category_first",new Category1Mapper());
    }
}
