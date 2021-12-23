package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import users.Users;

import javax.swing.*;

public class JDBC {
    private static Connection conn = null;

    private static String Name = "root";
    private static String psw = "666666";
    private static String URL = "jdbc:mysql://localhost:3306/users?characterEncoding=UTF-8";
    private static String DName = "com.mysql.jdbc.Driver";

    private static PreparedStatement prs = null;

    private static ResultSet rs = null;
    private static ResultSet us = null;
    private static Statement st = null;

    public static Connection getConn() {
        //1. 加载驱动
        try {
            Class.forName(DName);
            System.out.println("数据库驱动加载成功 ！");
        } catch (ClassNotFoundException e1) {
            // TODO 自动生成的 catch 块
            e1.printStackTrace();
        }
        //2. 连接数据库
        try {
            conn = DriverManager.getConnection(URL, Name, psw);
            System.out.println("连接成功，获取连接对象： " + conn);
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

        return conn;
    }


    //1. 查询所有用户的信息
    public static ResultSet quer(String sql) {
        rs = null;
        conn = getConn();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return rs;
    }


    //2. 根据用户名查询用户的信息
    public static ResultSet Result(String sql, String name) {
        us = null;
        conn = getConn();
        try {
            st = conn.createStatement();
            us = st.executeQuery(sql);
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return us;
    }


    //3. 带参数更新
    public static int update(String sql, Object[] obj) {
        int n = 0;
        conn = getConn();
        try {
            prs = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                prs.setObject(i + 1, obj[i]);
            }
            n = prs.executeUpdate();
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return n;
    }

//    //4. 根据管理员用户名查询管理员的信息
//    public static ResultSet Aesult(String sql, String name) {
//        us = null;
//        conn = getConn();
//        try {
//            st = conn.createStatement();
//            us = st.executeQuery(sql);
//        } catch (SQLException e) {
//            // TODO 自动生成的 catch 块
//            e.printStackTrace();
//        }
//        return us;

//    public static void main(String[] args) {
//        System.out.println(getConn());
//    }

}

