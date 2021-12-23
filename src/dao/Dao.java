package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import users.Users;
import util.JDBC;

import javax.swing.*;

public class Dao {

    //1. 插入用户信息
    public boolean insertUser(Users user) {
        boolean res = false;
        String sql = "INSERT user(`name`,`password`) VALUES(?,?)";
        Object[] obj = {user.getName(), user.getPassword()};
        int n = JDBC.update(sql, obj);
        if (n > 0) {
            res = true;
            System.out.println("成功插入" + n + "条数据！");
        }
        return res;
    }


    //2. 根据用户名获得用户密码
    public String getUser(String name) {
        String paw = "";
        String sql = " SELECT password FROM user where name ='" + name + "'";
        ResultSet us = null;
        us = JDBC.Result(sql, name);

        while (true) {
            try {
                if (!us.next()) break;

                paw = us.getString("password");
                return paw;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return paw;
    }

//    //3. 根据用户名获得用户所有信息
//    public String getUser(String name) {
//        String sql = " SELECT * FROM user where name ='" + name + "'";
//        ResultSet us = null;
//        us = JDBC.Result(sql, name);
//
//        while (true) {
//            try {
//                if (!us.next()) break;
//
//                paw = us.getString("password");
//                return paw;
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//
//        }
//        return paw;
//    }

    //4. 更改用户密码
    public boolean update(Users user, String name) {
        boolean res = false;
        String sql = "UPDATE user SET name = ?,password = ? WHERE name ='" + name + "'";
        Object[] obj = {user.getName(), user.getPassword()};
        int n = JDBC.update(sql, obj);
        if (n > 0) {
            res = true;
            System.out.println("成功更改" + n + "条数据！");
        }
        return res;
    }

    //5. 获得并输出所有用户信息
    public List<Users> getAllUsers() {
        List<Users> list = new ArrayList<Users>();
        String sql = " SELECT * FROM user";
        ResultSet rs = null;
        rs = JDBC.quer(sql);
        try {
            while (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));

                list.add(user);
            }
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return list;
    }

//    //2. 根据用户名获得用户信息
//    public String getUsers(String name) {
//
//        String sql = " SELECT * FROM user where name ='" + name + "'";
//        ResultSet us = null;
//        us = JDBC.Result(sql, name);
//
//        while (true) {
//            try {
//                if (!us.next()) break;
//
//                paw = us.getString("password");
//                return paw;
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//
//        }
//        return paw;
//    }
}

