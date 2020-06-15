package app.model.entities.hotel;

import app.model.entities.apartment.Apartment;
import app.model.entities.order.Order;
import app.model.entities.person.client.Client;
import app.model.entities.requisiiton.Requisition;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private static Hotel instance = null;
    private List<Requisition> requisitions = new ArrayList<Requisition>();
    private List<Apartment> apartments = new ArrayList<Apartment>();
    private List<Client> clients = new ArrayList<Client>();
    private List<Order> orders = new ArrayList<Order>();
    private int stars = 1;
    private int earnings = 0;

    private Hotel() throws Exception {

    }

    public static Hotel getInstance() throws Exception {
        if(instance == null)
        {
            instance = new Hotel();
        }
        return instance;
    }

    public int getEarnings() {
        return earnings;
    }

    public int getStars() {
        return stars;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public List<Requisition> getRequisitions() {
        return requisitions;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public void setRequisitions(List<Requisition> requisitions) {
        this.requisitions = requisitions;
    }


    @Override
    public String toString() {
        return "Hotel{" +
                "stars=" + stars +
                ", earnings=" + earnings +
                '}';
    }
}