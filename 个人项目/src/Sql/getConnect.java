package Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class getConnect {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            // 建立与数据库的Connection连接
            // 这里需要提供：
            // 数据库所处于的ip:localhost (本机)
            // 数据库的端口号： 3306 （mysql专用端口号）
            // 数据库名称 cakes
            // 编码方式 UTF-8
            // 账号 root
            // 密码 666666

            Connection c = DriverManager
                    .getConnection(
                            "jdbc:mysql://localhost:3306/cakes?characterEncoding=UTF-8",
                            "root", "666666");

            System.out.println("连接成功，获取连接对象： " + c);

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

