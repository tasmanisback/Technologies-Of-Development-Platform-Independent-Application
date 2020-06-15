package app.controller.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class MainMenuAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
        switch(action)
        {
            case "requisition":{
                getServletContext().getRequestDispatcher("/view/list_requisitions.jsp").forward(req, resp);
                break; }
            case "order" : {   getServletContext().getRequestDispatcher("/view/creation_order.jsp").forward(req,resp); break;}
            case "client" : {  getServletContext().getRequestDispatcher("/view/list_clients.jsp").forward(req,resp); break;}
            case "apartment" : {    getServletContext().getRequestDispatcher("/view/list_apartments.jsp").forward(req,resp); break;}
            case "exit" : { req.getRequestDispatcher("/view/entry_form.jsp").forward(req,resp);}
            case "back" : { req.getRequestDispatcher("view/main_menu_admin.jsp").forward(req,resp); break;}
            case "createUser" : { req.getRequestDispatcher("/view/create_user.jsp").forward(req,resp);  break;}
            case "removeUser" : { req.getRequestDispatcher("/view/remove_user.jsp").forward(req,resp);  break;}
            case "createApartment" : { req.getRequestDispatcher("/view/create_apartment.jsp").forward(req,resp); break;}
            case "removeApartment" : { req.getRequestDispatcher("/view/remove_apartment.jsp").forward(req,resp); break;}
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
     }

}
