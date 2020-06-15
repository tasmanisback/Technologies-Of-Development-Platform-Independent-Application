package app.model.entities.apartment;

public class Apartment {
    private int number = 1;
    private int countRooms = 1;
    private RoomClass roomClass = RoomClass.TYPE_A;
    private boolean busy = false;
    private String clientLogin = null;

    public Apartment(int number, int countRooms, RoomClass roomClass) throws Exception {
        setNumber(number);
        setCountRooms(countRooms);
        setRoomClass(roomClass);
    }

    public Apartment(int countRooms, RoomClass roomClass)
    {
        setCountRooms(countRooms);
        setRoomClass(roomClass);
    }

    public Apartment(int number, int count_rooms, int room_class,String clientLogin) {
        setNumber(number);
        setCountRooms(count_rooms);
        setClientLogin(clientLogin);
        RoomClass roomClass;
        switch (room_class)
        {
            case 2:roomClass=RoomClass.TYPE_B;break;
            case 3:roomClass=RoomClass.TYPE_C;break;
            case 4:roomClass=RoomClass.LUX;break;
            default:
                roomClass = RoomClass.TYPE_A;
        }
        setRoomClass(roomClass);
    }

    public String getClientLogin() {
        return clientLogin;
    }

    public void setClientLogin(String clientLogin) {
        this.clientLogin = clientLogin;
    }

    public boolean isBusy()
    {
        return this.busy;
    }


    public void setCountRooms(int countRooms) {
        if(countRooms>0)
        {
            this.countRooms = countRooms;
        }
        else
            throw new IllegalArgumentException("Unavailable count of rooms");
    }

    public void setRoomClass(RoomClass roomClass) {
        this.roomClass = roomClass;
    }


    public void setNumber(int number) {
        this.number = number;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public int getNumber() {
        return number;
    }

    public int getCountRooms() {
        return countRooms;
    }

    public RoomClass getRoomClass() {
        return roomClass;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "countRooms=" + countRooms +
                ", roomClass=" + roomClass +
                ", busy=" + busy +
                "}";
    }
}