package app.controller.service;


import app.controller.dao.entitiesDAO.*;
import app.model.entities.hotel.Hotel;

import java.sql.SQLException;

public class HotelService {
    private static Hotel hotel;


    public HotelService() throws Exception {
        HotelDAO hd = new HotelDAO();
        hotel = hd.getInf();
    }

    public void setEntitiesBetweenClientHotel() throws SQLException, SQLException, ClassNotFoundException {
        ClientDAO cd = new ClientDAO();
        hotel.setClients(cd.getAll());
    }

    public void setEntitiesBetweenApartmentHotel() throws Exception {
        ApartmentDAO ad = new ApartmentDAO();
        hotel.setApartments(ad.getAll());
    }

    public void setEntitiesBetweenHotelRequisitions() throws Exception {
        RequisitionDAO ad = new RequisitionDAO();
        hotel.setRequisitions(ad.getAll());
    }


    public void setEntitiesBetweenHotelOrders() throws Exception {
        OrderDAO ad = new OrderDAO();
        hotel.setOrders(ad.getAll());
    }

}
