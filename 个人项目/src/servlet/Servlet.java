package servlet;

import dao.Dao;
import users.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet("/login")
public class Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username1");
        String password = request.getParameter("password1");
//        Users user = new Users(name, password);
//        List<Users> list = new ArrayList<Users>();
//        list.add(user);
//        System.out.println(list.get(0));


        if (name.equals("Admin") && password.equals("NEUQ_King")) {
            //管理员密码正确进入主页
            request.getRequestDispatcher("/ad-index.jsp").forward(request, response);

        }
        if (getUser(name).equals(password)) {
            //用户密码正确进入主页
            request.getRequestDispatcher("/index.html").forward(request, response);
        } else {
            //用户名或密码错误
            String inf = "用户名或密码错误！";
            request.setAttribute("inf", inf);
            request.setAttribute("name", name);
            request.getRequestDispatcher("/").forward(request, response);
        }

    }

    Dao userDao = new Dao();

    public List<Users> showUsers() {
        return userDao.getAllUsers();
    }

    public String getUser(String user) {
        return userDao.getUser(user);
    }


}

