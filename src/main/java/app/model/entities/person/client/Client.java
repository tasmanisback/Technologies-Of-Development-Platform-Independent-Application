package app.model.entities.person.client;

import app.model.entities.apartment.Apartment;
import app.model.entities.person.Person;

public class Client extends Person {

    private int apartmentNumber=0;
    private int money = 0;
    private boolean room = false;

    public Client(String name, int age, String login, String password, int money)
    {
        super(name,age,login,password);
        setMoney(money);
    }
    public Client(String name, int age, String login, String password, int money,int apartmentNumber)
    {
        super(name,age,login,password);
        System.out.println(password);
        setMoney(money);
        setApartmentNumber(apartmentNumber);
    }


    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public boolean hasRoom()
    {
        if(room)
            return true;
        return false;
    }

    public int getMoney() {
        return money;
    }

    public void setRoom(boolean room)
    {
        this.room = room;
    }

    public void setMoney(int money)
    {
        if(money >= 0)
        {
            this.money = money;
        }
        else
            throw new IllegalArgumentException("Money is unavailable");
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getLogin() {
        return super.getLogin();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String toString() {
        return "Client{" +
                "room=" + room +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
