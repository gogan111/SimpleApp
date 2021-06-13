package com.andrey.simpleApp.servlet;

import com.andrey.simpleApp.dao.UserDao;
import com.andrey.simpleApp.dao.UserDaoImpl;
import com.andrey.simpleApp.domain.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    UserDao userDao = new UserDaoImpl();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        List<User> userList = userDao.getUsers();
        req.setAttribute("list", userList);

        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
