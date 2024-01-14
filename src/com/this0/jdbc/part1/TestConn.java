package com.this0.jdbc.part1;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * @Author yupengtao
 * @Date 2023/6/25 23:51
 **/
public class TestConn {
    public static void main(String[] args) throws Exception {

        //        mysql连接测试

        //        1、模块添加了依赖的mysql驱动相关库

        //        2、通过反射，在内存中加载驱动类（可选）
        //新版的mysql驱动jar可以省略这步，旧版的mysql驱动jar必须加这一步。
        Class.forName("com.mysql.cj.jdbc.Driver");

        //        3、连接数据库
        String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
        String user = "root";
        String passwd = "root";
        Connection conn = DriverManager.getConnection(url, user, passwd);
        System.out.println("mysql连接成功：conn = " + conn);

        //        4、操作数据库

        //5、释放资源
        conn.close();
    }
}