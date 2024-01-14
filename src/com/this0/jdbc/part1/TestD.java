package com.this0.jdbc.part1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @Author yupengtao
 * @Date 2023/6/26 00:56
 **/
public class TestD {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
        String user = "root";
        String passwd = "root";
        Connection conn = DriverManager.getConnection(url, user, passwd);

//        4、操作数据库
        String sql = "delete from jdbctest where name='张三改名' || name= '李四'";//发给服务器的sql
        PreparedStatement pst = conn.prepareStatement(sql);

        int len = pst.executeUpdate();
        //返回sql影响的记录数
        System.out.println(len > 0 ? "删除成功" : "删除失败");
        pst.close();
        conn.close();
    }
}