package app.controller.servlets;

import app.controller.dao.entitiesDAO.ApartmentDAO;
import app.controller.dao.entitiesDAO.ClientDAO;
import app.controller.dao.entitiesDAO.OrderDAO;
import app.model.entities.apartment.Apartment;
import app.model.entities.order.Order;
import app.model.entities.person.client.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class OrderUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = (String)req.getParameter("action");
        HttpSession s = req.getSession();
        Order order = (Order)s.getAttribute("order");
        String login = (String)s.getAttribute("login");
        s.setAttribute("login",login);
        switch(action)
        {
            case"exit":
            {
                break;
            }
            case"accept": {
                try {
                    ClientDAO co = new ClientDAO();
                    Client client = co.getEntityById(login);
                    if (client.getMoney() >= order.getPayment()) {
                        client.setMoney(client.getMoney() - order.getPayment());
                        client.setApartmentNumber(order.getApartment_number());
                        ApartmentDAO aps = new ApartmentDAO();
                        Apartment ap = aps.getEntityById(order.getApartment_number());
                        ap.setClientLogin(client.getLogin());
                        aps.update(ap);
                        OrderDAO od = new OrderDAO();
                        od.delete(order.getId());
                    } else {
                        PrintWriter pw = resp.getWriter();
                        pw.println("Not enough money!!!");
                    }
                    break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
                case"decline":
            {
                OrderDAO od = null;
                try {
                    od = new OrderDAO();
                    od.delete(order.getId());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
               break;
            }
        }
        req.getRequestDispatcher("/view/main_menu_user.jsp").forward(req,resp);
    }
}
