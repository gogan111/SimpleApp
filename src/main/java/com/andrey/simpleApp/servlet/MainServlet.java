package com.andrey.simpleApp.servlet;

import com.andrey.simpleApp.domain.User;
import com.andrey.simpleApp.domain.validator.UserValidator;
import com.andrey.simpleApp.service.UserService;
import com.andrey.simpleApp.service.UserServiceImpl;

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
    UserService userService = new UserServiceImpl();

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
        List<User> userList = userService.getUsers();

        req.setAttribute("users", userList);

        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {
            case "add":
                addUserAction(req);
                break;
            case "delete":
                deleteUserAction(req);
                break;
            case "update":
                updateUserAction(req);
                break;
        }
        doGet(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    private void addUserAction(HttpServletRequest req) {
        User user = null;
        UserValidator userValidator = null;

        int id = Integer.parseInt(req.getParameter("id"));
        int age = 0;
        if (!req.getParameter("age").isEmpty()) {
            age = Integer.parseInt(req.getParameter("age"));
        }
        String name = req.getParameter("name").trim();
        String surname = req.getParameter("surname").trim();
        String email = req.getParameter("email").trim();

        user = new User(id, name, surname, age, email);
        userValidator = new UserValidator(user);




        if (userValidator.hasErrors()) {
            req.setAttribute("updateUser", user);
            req.setAttribute("validator", userValidator);

            return;
        }

        if (id < 0) {
            userService.saveUser(user);
        } else {
            userService.updateUser(user);
        }
    }

    private void updateUserAction(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("userId"));

        User updateUser = userService.getUser(id);

        req.setAttribute("updateUser", updateUser);
    }

    private void deleteUserAction(HttpServletRequest req) {
        int userId = Integer.parseInt(req.getParameter("userId"));

        userService.deleteUser(userId);
    }
}
