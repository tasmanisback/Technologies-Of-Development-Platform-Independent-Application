package app.model.entities.requisiiton;

import app.model.entities.apartment.Apartment;
import app.model.entities.apartment.RoomClass;
import app.model.entities.requisiiton.date.Date;

import static app.model.entities.apartment.RoomClass.TYPE_B;

public class Requisition {

    private int id = 0;
    private String description = "";
    private int count_rooms;
    private RoomClass roomClass;
    private String client_login;
    private Date arrivalDate = new Date(2000,1,1);
    private Date departureDate = new Date(2000,1,2);

    public Requisition(int id,String description,int count_rooms,int room_class, String arrivalDate, String departureDate,String client_login)
    {
        setClient_login(client_login);
        setId(id);
        setArrivalDate(arrivalDate);
        setDescription(description);
        setDepartureDate(departureDate);
        RoomClass roomClass;
        switch (room_class)
        {
            case 2:roomClass= TYPE_B;break;
            case 3:roomClass=RoomClass.TYPE_C;break;
            case 4:roomClass=RoomClass.LUX;break;
            default:
                roomClass = RoomClass.TYPE_A;
        }
        setRoomClass(roomClass);
        setCount_rooms(count_rooms);
    }



    public String getClient_login() {
        return client_login;
    }

    public void setClient_login(String client_login) {
        this.client_login = client_login;
    }

    public Requisition(int id, String description, Apartment apartment, String arrivalDate, String departureDate)
    {
        setId(id);
        setArrivalDate(arrivalDate);
        setDescription(description);
        setDepartureDate(departureDate);
    }


    public void setRoomClass(RoomClass roomClass) {
        this.roomClass = roomClass;
    }

    public Integer getRoomClass() {
        switch (roomClass)
        {
            case TYPE_B: return 2;
            case TYPE_C: return 3;
            case LUX: return 4;
            default:
                return 1;
        }
    }

    public int getCount_rooms() {
        return count_rooms;
    }

    public void setCount_rooms(int count_rooms) {
        this.count_rooms = count_rooms;
    }

    public String getArrivalDate() {
        return arrivalDate.toString();
    }

    public String getDepartureDate() {
        return departureDate.toString();
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }



    public void setDescription(String description) {
        if(description!=null)
            this.description = description;
        else throw  new IllegalArgumentException("Description is null");

    }

    public void setArrivalDate(String arrivalDate) {
        if(arrivalDate!=null)
            this.arrivalDate = new Date(arrivalDate);
        else throw  new IllegalArgumentException("Arrival date is null");

    }

    public void setDepartureDate(String departureDate) {
        if(departureDate!=null)
            this.departureDate = new Date(departureDate);
        else throw  new IllegalArgumentException("Departure date is null");

    }

    @Override
    public String toString() {
        return "Requisition{" +
                "id=" + id +
                ", description='" + description + '\''+
                ", arrivalDate=" + arrivalDate +
                ", departureDate=" + departureDate +
                '}';
    }
}
