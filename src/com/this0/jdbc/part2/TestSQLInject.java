package com.this0.jdbc.part2;


import org.junit.Test;

import java.sql.*;
import java.util.Scanner;

/**
 * @Author yupengtao
 * @Date 2024/1/15 01:30
 **/
public class TestSQLInject {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入你要查询的用户编号：");
        String id = input.nextLine();
        // 正常输入：1
        // 恶意输入：10 or id=1  第一个1表示用户编号， 后面 or 1= 1表示条件，而1=1是永远成立，其他条件全部失效

        String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
        String user = "root";
        String passwd = "root";
        Connection conn = DriverManager.getConnection(url, user, passwd);

        String sql = "select * from jdbctest where id = " + id;
        System.out.println("sql = " + sql);
        PreparedStatement pst = conn.prepareStatement(sql);

        //执行查询
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            for (int i = 1; i < 3; i++) {
                Object object = rs.getObject(i);
                if (object instanceof Integer) {
                    System.out.print((Integer) object + " ");
                } else {
                    System.out.print(object + " ");
                }
            }
        }

        rs.close();
        pst.close();
        conn.close();
        input.close();
    }
}