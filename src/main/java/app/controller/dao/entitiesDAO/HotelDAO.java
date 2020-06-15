package app.controller.dao.entitiesDAO;

import app.controller.dao.DataSource.DataSource;
import app.model.entities.hotel.Hotel;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;

public class HotelDAO {
    private static final String select = "SELECT * FROM hotel";
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public HotelDAO() throws SQLException, ClassNotFoundException {
//        BasicDataSource bds = DataSource.getInstance().getBds();
//        connection = bds.getConnection();
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC","root","2910post");

    }

    public Hotel getInf() throws Exception {
        Hotel hotel = Hotel.getInstance();
        ps = connection.prepareStatement(select);
        rs = ps.executeQuery();
        while(rs.next())
        {
            hotel.setStars(Integer.parseInt(rs.getString("stars")));
            hotel.setEarnings(Integer.parseInt(rs.getString("earnings")));
        }
        return hotel;
    }

    public void update(Hotel hotel) throws SQLException {
        String sql = "UPDATE hotel SET stars = ?, earnings = ?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1,hotel.getStars());
        ps.setInt(2,hotel.getEarnings());
        ps.executeUpdate();
    }

}