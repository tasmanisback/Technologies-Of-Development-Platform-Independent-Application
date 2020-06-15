package app.controller.servlets;

import app.controller.dao.entitiesDAO.OrderDAO;
import app.controller.service.ClientService;
import app.controller.service.HotelService;
import app.model.entities.hotel.Hotel;
import app.model.entities.order.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch(action)
        {
            case "order":{
                Integer ap_numb = Integer.parseInt(req.getParameter("apartment_number"));
                String client_login = req.getParameter("client_login");
                String description = req.getParameter("description");
                Integer payment = Integer.parseInt(req.getParameter("payment"));
                try {
                    if(payment>0&& ClientService.existLogin(client_login) &&ap_numb>0)
                    {
                        try {
                            Hotel hotel = Hotel.getInstance();
                            HotelService hs = new HotelService();
                            Order order = new Order(hotel.getOrders().size(),payment,description,ap_numb,client_login);
                            OrderDAO od = new OrderDAO();
                            od.create(order);
                            req.getRequestDispatcher("/view/main_menu_admin.jsp").forward(req,resp);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    else
                    {
                        PrintWriter pw = resp.getWriter();
                        pw.println("Invalid data!!!Try again");
                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "exit":{
                req.getRequestDispatcher("view/main_menu_admin.jsp");break;
            }
        }

    }
}
