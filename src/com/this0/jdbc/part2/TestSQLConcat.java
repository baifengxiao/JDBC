package com.this0.jdbc.part2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author yupengtao
 * @Date 2023/6/25 17:44
 **/
public class TestSQLConcat {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
        String user = "root";
        String passwd = "root";
        Connection conn = DriverManager.getConnection(url, user, passwd);

//        4、操作数据库
        String sql = "insert into jdbctest(id,name,passwd) values (?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);

        //占位符1：
        // 要给每一个？指定具体的值
//        PreparedStatement支持给每一个字段指定值时，确定数据类型，例如：
        pst.setInt(1, 3);//这里的1，表示第1个？
        pst.setString(2, "王五");//这里的2，表示第2个？
        pst.setString(3, "王五的密码");

        //        占位符2：
//        但是这样有点麻烦，还要一一去确定数据类型
//                PreparedStatement支持用Object统一处理
        String sql2 = "insert into jdbctest(id,name,passwd) values (?,?,?)";
        PreparedStatement pst2 = conn.prepareStatement(sql);
        pst2.setObject(1, 4);
        pst2.setObject(2, "赵六");
        pst2.setObject(3, "赵六的密码");

        pst.executeUpdate();
        pst2.executeUpdate();


        //5、释放资源
//        rs.close();
        pst.close();
        pst2.close();
        conn.close();
    }
}