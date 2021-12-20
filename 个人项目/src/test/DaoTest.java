package test;

import dao.Dao;
import users.Users;

import java.util.List;

public class DaoTest {

    public static void main(String[] args) {
        Users user = new Users("TOLIE_OFFICIAL", "WZH190317");

        Dao udao = new Dao();
        if (udao.insertUser(user)) {
            System.out.println("插入数据成功!");
        }
        List<Users> usersList = udao.getAllUsers();
        for (Users users : usersList
        ) {
            System.out.println(users.toString());
        }
//        String usersList = udao.getUser("2");
//        for (Users users : usersList
//        ) {
//            System.out.println(users.toString());
//        }

    }
}
