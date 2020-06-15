package app.controller.servlets;

import app.controller.dao.entitiesDAO.ClientDAO;
import app.controller.service.ClientService;
import app.controller.service.HotelService;
import app.model.entities.hotel.Hotel;
import app.model.entities.person.client.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class EnterServlet extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "2910post";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Hotel hotel = Hotel.getInstance();
            HotelService hs = new HotelService();
            hs.setEntitiesBetweenHotelRequisitions();
            hs.setEntitiesBetweenHotelOrders();
            hs.setEntitiesBetweenApartmentHotel();
            hs.setEntitiesBetweenClientHotel();
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            if(login.equals("admin")&&password.equals("admin"))
            {
                req.getRequestDispatcher("/view/main_menu_admin.jsp").forward(req, resp);
            }
            else {
                boolean log = ClientService.tryEnter(login, password);
                if (log) {
                    HttpSession s = req.getSession();
                    s.setAttribute("login", login);
                    req.getRequestDispatcher("/view/main_menu_user.jsp").forward(req, resp);
                } else {
                    PrintWriter pw = resp.getWriter();
                    pw.println("Incorrect login or password. Check your input data!!!");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

