package servlet;

import dao.Dao;
import users.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class chgServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldname = request.getParameter("oldname");
        String username = request.getParameter("username2");
        String password = request.getParameter("password2");
        Users user = new Users(username,password);
        if(update(user,oldname)){
            String inf = "信息修改成功！";
            request.setAttribute("inf", inf);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }else {
            String inf = "原用户名错误！";
            request.setAttribute("inf", inf);
            request.getRequestDispatcher("/chg.jsp").forward(request, response);
        }

    }

    Dao userDao = new Dao();
    public boolean update(Users user, String name){
        return userDao.update(user, name);

    }

}
