package app.controller.dao.entitiesDAO;

import app.controller.dao.AbstractController;
import app.controller.dao.DataSource.DataSource;
import app.model.entities.person.client.Client;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements AbstractController<Client,String> {
    private static final String select = "SELECT * FROM client";
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ClientDAO() throws SQLException, ClassNotFoundException {
        // BasicDataSource bds = DataSource.getInstance().getBds();
        //connection = bds.getConnection();
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC","ИМЯ ПОЛЬЗОВАТЕЛЯ(ТЕБЯ)","ПАРОЛЬ(ТВОЙ)");
    }

    public List<Client> getAll() throws SQLException {
        ps = connection.prepareStatement(select);
        rs = ps.executeQuery();
        List<Client> clients = new ArrayList<Client>();
        while(rs.next())
        {
            Client client = new Client(rs.getString("pName"),
                    Integer.parseInt(rs.getString("age")),
                    rs.getString("login"),rs.getString("password"),
                    Integer.parseInt(rs.getString("money")),rs.getInt("apartment_number"));
            clients.add(client);
        }

        return clients;
    }

    public Client getEntityById(String login) throws SQLException {
        Client client = null;
        String sql = select +" where login = ?";
        ps = connection.prepareStatement(sql);
        ps.setString(1,login);
        rs = ps.executeQuery();
        if(rs.next())
        {
            client= new app.model.entities.person.client.Client(rs.getString("pName"),
                    Integer.parseInt(rs.getString("age")),
                    rs.getString("login"),rs.getString("password"),
                    Integer.parseInt(rs.getString("money")),rs.getInt("apartment_number"));
        }
        return client;
    }

    public void update(Client entity) throws SQLException {
        String sql = "UPDATE client SET pName = ?, age = ?, money = ? apartment_number = ? WHERE login = ?";
        ps = connection.prepareStatement(sql);
        ps.setString(1,entity.getName());
        ps.setInt(2,entity.getAge());
        ps.setInt(3,entity.getMoney());
        ps.setInt(4,entity.getApartmentNumber());
        ps.setString(5,entity.getLogin());
        ps.executeUpdate();
    }

    public void delete(String login) throws SQLException {
        String query = "delete from client where login = ?";
        ps = connection.prepareStatement(query);
        ps.setString(1, login);
        ps.executeUpdate();
    }

    public void create(Client entity) throws SQLException {
        String sql = "INSERT INTO client (pName, age, money, login, password, apartment_number) "
                +"VALUES (?,?,?,?,?,?)";
        ps = connection.prepareStatement(sql);
        ps.setString(1,entity.getName());
        ps.setInt(2,entity.getAge());
        ps.setInt(3,entity.getMoney());
        ps.setString(4,entity.getLogin());
        ps.setString(5,entity.getPassword());
        ps.setInt(6,entity.getApartmentNumber());
        ps.executeUpdate();

    }

}