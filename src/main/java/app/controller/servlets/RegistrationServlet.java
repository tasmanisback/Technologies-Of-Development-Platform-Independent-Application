package app.controller.servlets;

import app.controller.service.ClientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        try {
            if(!ClientService.existLogin(login))
            {
                HttpSession s = req.getSession();
                s.setAttribute("Login",login);
                RequestDispatcher rd = req.getRequestDispatcher("/view/continue_registration.jsp");
                rd.forward(req, resp);
            }
                else
            {
                PrintWriter pw = resp.getWriter();
                pw.println("Create new login. Such login already exist");
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s = req.getSession();
        String login = (String) s.getAttribute("Login");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String password = req.getParameter("password");
        int money = Integer.parseInt(req.getParameter("money"));
        try {
            ClientService.createClient(login,name,age,password,money);
            req.getRequestDispatcher("/view/entry_form.jsp").forward(req,resp);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }
}