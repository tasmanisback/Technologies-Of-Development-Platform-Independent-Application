package app.controller.servlets;

import app.controller.dao.entitiesDAO.ApartmentDAO;
import app.model.entities.apartment.Apartment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeApartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        int numb = Integer.parseInt(req.getParameter("number_apartment"));
        try {
            if(numb!=0)
            {
                switch(action)
                {
                    case "createApartment" :{
                        String room_class = req.getParameter("room_class");
                        int roomClass = 0;
                        switch(room_class)
                        {
                            case "LUX":roomClass = 1; break;
                            case "A":roomClass = 2; break;
                            case "B":roomClass = 3; break;
                            case "C":roomClass = 4; break;
                        }
                        int countRooms = Integer.parseInt(req.getParameter("count_rooms"));
                        Apartment apartment = new Apartment(numb,countRooms,roomClass,null);
                        ApartmentDAO ap = new ApartmentDAO();
                        ap.create(apartment);
                        break;
                    }
                    case "removeApartment":{
                        ApartmentDAO ap = new ApartmentDAO();
                        ap.delete(numb);
                        break;}
                }
            }
        }
        catch (Exception exception)
        {

        }
        req.getRequestDispatcher("/view/main_menu_admin.jsp").forward(req,resp);

    }
}
