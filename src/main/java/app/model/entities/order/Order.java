package app.model.entities.order;

public class Order {
    private int apartment_number;
    private int payment = 0;
    private String client_login;
    private int id = 0;
    private String description;

    public Order()
    {

    }

    public Order(int id, int payment, String description, int apartment_number, String client_login)
    {
        setId(id);
        setDescription(description);
        setPayment(payment);
        setApartment_number(apartment_number);
        setClient_login(client_login);
    }

    public Order(int id, int payment, String description)
    {
        setId(id);
        setDescription(description);
        setPayment(payment);
    }

    public void setApartment_number(int apartment_number) {
        this.apartment_number = apartment_number;
    }

    public void setClient_login(String client_login) {
        this.client_login = client_login;
    }

    public int getApartment_number() {
        return apartment_number;
    }

    public String getClient_login() {
        return client_login;
    }

    public int getPayment() {
        return payment;
    }

    public int getId() {
        return id;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "Order{" +
                ", payment=" + payment +
                ", id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
