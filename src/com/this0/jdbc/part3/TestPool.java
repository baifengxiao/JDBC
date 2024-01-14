package com.this0.jdbc.part3;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * @Author yupengtao
 * @Date 2023/6/25 23:19
 **/
public class TestPool {
    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        //因为druid.properties文件是在src下，最后会随着.java文件一起编译到类路径下（class）
        //可以通过类加载器帮我们加载资源配置文件
        pro.load(TestPool.class.getClassLoader().getResourceAsStream("druid.properties"));
        //数据连接池工厂，创建数据连接池
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        Connection conn = ds.getConnection();
        System.out.println("使用数据库连接池连接成功：conn = " + conn);

        conn.close();

    }
}
