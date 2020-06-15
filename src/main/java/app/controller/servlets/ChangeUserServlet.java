package app.controller.servlets;

import app.controller.dao.entitiesDAO.ClientDAO;
import app.controller.service.ClientService;
import app.model.entities.person.client.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ChangeUserServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String login = req.getParameter("login");
        try {
            if(login!=null)
            {
                    switch(action)
                    {
                        case "createUser" : {
                            if(!ClientService.existLogin(login))
                            {
                            String password = req.getParameter("password");
                            String name = req.getParameter("name");
                            int age = Integer.parseInt(req.getParameter("age"));
                            int balance = Integer.parseInt(req.getParameter("balance"));
                            if(password!=null&&name!=null&age>0&&balance>=0)
                            {
                                Client client = new Client(name,age,login,password,balance);
                                ClientDAO co = new ClientDAO();
                                co.create(client);
                            }
                            }
                            break;}
                        case "removeUser" : {
                            if(ClientService.existLogin(login)) {
                                ClientDAO co = new ClientDAO();
                                co.delete(login);
                            }break;}
                    }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/view/main_menu_admin.jsp").forward(req,resp);
    }


}
