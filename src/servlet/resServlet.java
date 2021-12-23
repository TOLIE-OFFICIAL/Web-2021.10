package servlet;

import dao.Dao;
import users.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/resj")
public class resServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username2");
        String password = request.getParameter("password2");
        Users user = new Users(name, password);

        if (adduser(user)) {
            request.getRequestDispatcher("/signin.html").forward(request,response);
        }
    }

    public boolean adduser(Users users) {
        Dao userDao = new Dao();
        boolean res = false;
        res = userDao.insertUser(users);
        return res;
    }
}


