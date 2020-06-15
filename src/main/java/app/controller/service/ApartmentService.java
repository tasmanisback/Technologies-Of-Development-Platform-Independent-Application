package app.controller.service;

import app.controller.dao.entitiesDAO.ApartmentDAO;
import app.model.entities.apartment.Apartment;

import java.sql.SQLException;

public class ApartmentService {
    public static boolean isExist(int number_room) throws SQLException, ClassNotFoundException {
        ApartmentDAO aps = new ApartmentDAO();
        Apartment ap = aps.getEntityById(number_room);
                if(ap==null)
        return false;
                return true;
    }

}
