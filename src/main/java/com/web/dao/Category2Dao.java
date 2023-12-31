package com.web.dao;

import com.web.entity.Category2;
import com.web.mapper.Category2Mapper;
import com.web.mapper.UserMapper;
import com.web.util.DBUtil;

import java.util.List;

public class Category2Dao {
//    查某一二级商品的所有商品
    public List get(int csid){
        return DBUtil.queryForList("select * from category_second where csId = ?", new Category2Mapper(),csid);
    }
//    根据二级商品名模糊查询
    public List getByName(String name){
        return DBUtil.queryForList("select * from category_second where csname like ?", new Category2Mapper() , "%"+name+"%");
    }
    public List getByCid(int cid){
        return DBUtil.queryForList("select * from category_second where cId = ?", new Category2Mapper() , cid);
    }
//    得到所有二级商品
    public List getAll(){
        return DBUtil.queryForList("select * from category_second",new Category2Mapper());
    }
//    删除某一二级商品
    public int delCategory2(int csid){
        return DBUtil.update("delete from category_second where csId =?",csid);
    }
//    新增二级商品
    public int addCategory2(String csname ,int cId){
        return DBUtil.update("Insert into category_second(csname,cId) values(?,?)",csname,cId);
    }
}
