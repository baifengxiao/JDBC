package com.this0.jdbc.part2;

import java.sql.*;

/**
 * @Author yupengtao
 * @Date 2024/1/15 02:26
 **/
public class TestSQLautoIncre {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
        String user = "root";
        String passwd = "root";
        Connection conn = DriverManager.getConnection(url, user, passwd);

        String sql = "insert into jdbctest(id,name,passwd) values (?,?,?)";

        //执行sql后，返回自增长键值
        PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setObject(1, 0);
        pst.setObject(2, "冯七");
        pst.setObject(3, "冯七的密码");

        pst.executeUpdate();
//        获取自增长键值
        ResultSet generatedKeys = pst.getGeneratedKeys();
        if (generatedKeys.next()) {
            //因为自增长键值只有一个，所以这里直接getObject(1)即可
            System.out.println("自增id值" + generatedKeys.getObject(1));
        }

        pst.close();
        conn.close();
    }
}