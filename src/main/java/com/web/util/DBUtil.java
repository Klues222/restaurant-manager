package com.web.util;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库工具类
 */
public class DBUtil {

    private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
    private static final String URL ="jdbc:mysql://localhost:3306/h_m?serverTimezone=GMT%2B8&characterEncoding=UTF-8";
    private static final String USER ="root";
    private static final String PASSWORD ="12345678";

    //静态块(最先执行并且只执行一次)
    static{
        try {
            //注册驱动
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 通用增删改方法
     * @param sql
     * @param args
     * @return
     */
    public static int update(String sql,Object...args){
        Connection con = null;
        PreparedStatement ps = null;
        int n = 0;
        try{
            //获取连接
            con = getConnection();
            //执行对象
            ps = con.prepareStatement(sql);
            //设置占位符
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1 , args[i]);
            }
            //执行
            n = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n;
    }


    /**
     * 通用查询单行数据返回对象方法
     * @param sql
     * @param mapper
     * @param args
     * @return
     */
    public static Object queryForObject(String sql,RowMapper mapper, Object...args){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object obj = null;
        try{
            //获取连接
            con = getConnection();
            //执行对象
            ps = con.prepareStatement(sql);
            //设置占位符
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1 , args[i]);
            }
            //执行sql返回结果集
            rs = ps.executeQuery();
            //循环遍历结果集
            while(rs.next()){
                obj = mapper.mapRow(rs);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

    /**
     * 通用查询多行数据  返回集合方法
     * @param sql
     * @param mapper
     * @param args
     * @return
     */
    public static List queryForList(String sql, RowMapper mapper, Object...args){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List list = new ArrayList();
        try{
            //获取连接
            con = getConnection();
            //执行对象
            ps = con.prepareStatement(sql);
            //设置占位符
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1 , args[i]);
            }
            //执行sql返回结果集
            rs = ps.executeQuery();
            //循环遍历结果集
            while(rs.next()){
                Object obj = mapper. mapRow(rs);
                list.add(obj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }





}
