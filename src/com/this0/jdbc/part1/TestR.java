package com.this0.jdbc.part1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author yupengtao
 * @Date 2023/6/26 00:56
 **/
public class TestR {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
        String user = "root";
        String passwd = "root";
        Connection conn = DriverManager.getConnection(url, user, passwd);

//        4、操作数据库
        String sql = "select * from jdbctest where name='张三'";//发给服务器的sql
        PreparedStatement pst = conn.prepareStatement(sql);

        ResultSet resultSet = pst.executeQuery();
        while (resultSet.next()){
            String uname=resultSet.getString("name");
            String upasswd =   resultSet.getString("passwd");
            System.out.println(uname+"的密码是"+upasswd);
        }

        //5、释放资源
        resultSet.close();
        pst.close();
        conn.close();
    }
}