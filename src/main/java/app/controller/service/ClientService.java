package app.controller.service;

import app.controller.dao.entitiesDAO.ClientDAO;
import app.controller.dao.entitiesDAO.OrderDAO;
import app.controller.dao.entitiesDAO.RequisitionDAO;
import app.model.entities.order.Order;
import app.model.entities.person.client.Client;
import app.model.entities.requisiiton.Requisition;

import java.sql.SQLException;
import java.util.List;

public class ClientService {
    public static boolean tryEnter(String login,String password) throws SQLException, ClassNotFoundException {
        ClientDAO co = new ClientDAO();
        List<Client> clientList = co.getAll();
        boolean log = false;
        for(Client c:clientList)
        {
            if(c.getLogin().equals(login)&&c.getPassword().equals(password))
            {
                log = true;
                break;
            }
        }
        return log;
    }

    public static void writeRequisition(int id, int roomClass, int countRooms, String arrivalDate, String depatureDate, String description,String client_login) throws Exception {
        Requisition req = new Requisition(id,description,countRooms,roomClass,arrivalDate,depatureDate,client_login);
        RequisitionDAO rd = new RequisitionDAO();
        rd.create(req);
    }

    public static boolean  existLogin(String login) throws SQLException, ClassNotFoundException {
        ClientDAO co = new ClientDAO();
        List<Client> clientList = co.getAll();
        for(Client c:clientList)
        {
            if(c.getLogin().equals(login))
            {
                return true;
            }
        }
        return false;
    }

    public static void createClient(String login, String name, int age, String password, int money) throws SQLException, ClassNotFoundException {
        Client client = new Client(name,age,login,password,money);
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.create(client);
    }

    public static Order checkOrder(String login) throws SQLException, ClassNotFoundException {
        OrderDAO dao = new OrderDAO();
        List<Order> orders = dao.getAll();
        for(Order order:orders)
        {
            if(order.getClient_login().equals(login))
            {
                return order;
            }
        }
        return null;
    }



}
