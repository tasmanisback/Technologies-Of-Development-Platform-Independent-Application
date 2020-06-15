package app.controller.dao.entitiesDAO;

import app.controller.dao.AbstractController;
import app.model.entities.apartment.Apartment;

import java.sql.*;

import app.controller.dao.DataSource.DataSource;
import app.model.entities.apartment.RoomClass;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.ArrayList;

public class ApartmentDAO implements AbstractController<Apartment,Integer> {
    private static final String select = "SELECT * FROM apartment";
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;


    public ApartmentDAO() throws SQLException, ClassNotFoundException {
        //BasicDataSource bds = DataSource.getInstance().getBds();
        //connection = bds.getConnection();
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC","root","2910post");
    }

    @Override
    public List<Apartment> getAll() throws Exception {
        ps = connection.prepareStatement(select);
        rs = ps.executeQuery();
        List<Apartment> apartments = new ArrayList<Apartment>();
        while(rs.next())
        {
            Apartment apartment = new Apartment( Integer.parseInt(rs.getString("numb")),
                    Integer.parseInt(rs.getString("count_rooms")),
                    Integer.parseInt(rs.getString("class_room")),rs.getString("client_login"));
            apartments.add(apartment);
        }
        return apartments;
    }



    @Override
    public Apartment getEntityById(Integer id) throws SQLException {
        Apartment apartment = null;
        String sql = select +" where numb = ?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
        rs = ps.executeQuery();
        if(rs.next())
        {
            apartment = new Apartment( Integer.parseInt(rs.getString("numb")),
                    Integer.parseInt(rs.getString("count_rooms")),
                    Integer.parseInt(rs.getString("class_room")),rs.getString("client_login"));
        }
        return apartment;
    }

    @Override
    public void update(Apartment entity) throws SQLException {
        String sql = "UPDATE apartment SET  count_rooms = ?, class_room = ?, busy = ?, client_login = ? WHERE numb = ?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1,entity.getCountRooms());
        ps.setString(2,entity.getRoomClass().toString());
        if(entity.isBusy())
            ps.setInt(3,0);
        else
            ps.setInt(3,1);
        ps.setString(4,entity.getClientLogin());
        ps.setInt(5,entity.getNumber());
        ps.executeUpdate();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String query = "delete from apartment where numb = ?";
        ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();

    }

    @Override
    public void create(Apartment entity) throws SQLException {
        String sql = "INSERT INTO apartment (numb, count_rooms, class_room,client_login) "
                +"VALUES (?,?,?,?)";
        int roomClass = 0;
        switch(entity.getRoomClass())
        {
            case LUX
                    :roomClass = 1; break;
            case TYPE_A:roomClass = 2; break;
            case TYPE_B:roomClass = 3; break;
            case TYPE_C:roomClass = 4; break;
        }
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,entity.getNumber());
        ps.setInt(2,entity.getCountRooms());
        ps.setInt(3,roomClass);
        ps.setString(4,"0");
        ps.executeUpdate();

    }
}