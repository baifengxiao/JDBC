package com.this0.jdbc.part1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * @Author yupengtao
 * @Date 2023/6/26 00:56
 **/
public class TestC {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
        String user = "root";
        String passwd = "root";
        Connection conn = DriverManager.getConnection(url, user, passwd);

//        4、操作数据库
//        通过Statement或PreparedStatement对象执行SQL

//        Statement对象执行SQL
        Statement statement = conn.createStatement();
        int row1 = statement.executeUpdate("insert into jdbctest values (1,'张三','abc123')");

//        PreparedStatement对象执行SQL
        String sql = "insert into jdbctest values (2,'李四','abc123')";//发给服务器的sql语句
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        int row2 = preparedStatement.executeUpdate();

        //返回sql影响的记录数
        System.out.println(row1 > 0 ? "Statement对象执行SQL添加成功" : "添加失败");
        System.out.println(row2 > 0 ? "PreparedStatement对象执行SQL添加成功" : "添加失败");

        //释放执行sql的资源
        statement.close();
        preparedStatement.close();

        //5、释放sql连接资源
        conn.close();
    }
}
