package app.controller.servlets;

import app.controller.dao.entitiesDAO.ClientDAO;
import app.controller.service.ApartmentService;
import app.controller.service.ClientService;
import app.controller.service.HotelService;
import app.model.entities.apartment.Apartment;
import app.model.entities.hotel.Hotel;
import app.model.entities.order.Order;
import app.model.entities.person.client.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class MainMenuUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s = req.getSession();
        String login = (String) s.getAttribute("Login");
        String room_class = req.getParameter("room_class");
        int roomClass = 0;
        switch(room_class)
        {
            case "LUX":roomClass = 1; break;
            case "A":roomClass = 2;break;
            case "B":roomClass = 3;break;
            case "C":roomClass = 4;break;
        }
        int countRooms = Integer.parseInt(req.getParameter("count_rooms"));
        String arrivalDate = req.getParameter("arrivalDate");
        String depatureDate = req.getParameter("depatureDate");
        String description = req.getParameter("description");

        try {
            Hotel hotel =  Hotel.getInstance();
            HotelService hotel1 = new HotelService();
            int id = hotel.getRequisitions().size();
            ClientService.writeRequisition(id,roomClass,countRooms,arrivalDate,depatureDate,description,login);
            req.getRequestDispatcher("/view/main_menu_user.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s = req.getSession();
        String login = (String) s.getAttribute("login");
        String action = (String)req.getParameter("action");
        switch (action)
        {
            case "exit" : { req.getRequestDispatcher("/view/entry_form.jsp").forward(req,resp); break;}
            case "order" :{
                try {
                    Order order = ClientService.checkOrder(login);
                    if(order!=null&&ApartmentService.isExist(order.getApartment_number()))
                    {
                        s.setAttribute("order",order);
                        req.getRequestDispatcher("/view/order_user.jsp").forward(req,resp);
                    }
                    else
                    {
                        req.getRequestDispatcher("/view/main_menu_user.jsp").forward(req,resp);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "profile" : {
                try{
                    ClientDAO cd = new ClientDAO();
                    Client client = cd.getEntityById(login);
                    s.setAttribute("client",client);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                req.getRequestDispatcher("/view/profile.jsp").forward(req,resp); break;}
        }

    }
}
