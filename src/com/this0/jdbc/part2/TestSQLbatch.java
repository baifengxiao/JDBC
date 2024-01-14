package com.this0.jdbc.part2;

import java.sql.*;

public class TestSQLbatch {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
        String user = "root";
        String passwd = "root";
        Connection conn = DriverManager.getConnection(url, user, passwd);

        String sql = "insert into jdbctest(id,name,passwd) values (?,?,?)";

        PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        for (int i = 1; i <= 1000; i++) {
            //设置1000次？的值
            pst.setObject(1, 0);
            pst.setObject(2, "冯七");
            pst.setObject(3, "冯七的密码");
//先攒着这些数据，设置完，sql会重新编译一下，生成一条新的完整的sql
            pst.addBatch();
        }
        //最后一口气执行
        pst.executeBatch();

        pst.close();
        conn.close();
    }
}