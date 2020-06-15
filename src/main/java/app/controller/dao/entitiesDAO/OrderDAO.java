package app.controller.dao.entitiesDAO;


import app.controller.dao.AbstractController;
import app.controller.dao.DataSource.DataSource;
import app.model.entities.order.Order;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements AbstractController<Order,Integer> {
    private static final String select = "SELECT * FROM orders";
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;


    public OrderDAO() throws SQLException, ClassNotFoundException {
        //BasicDataSource bds = DataSource.getInstance().getBds();
        //connection = bds.getConnection();
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC","root","2910post");

    }

    @Override
    public List<Order> getAll() throws SQLException {
        ps = connection.prepareStatement(select);
        rs = ps.executeQuery();
        List<Order> orders = new ArrayList<Order>();
        while(rs.next())
        {
            Order order = new Order(Integer.parseInt(rs.getString("id")),
                    Integer.parseInt(rs.getString("payment")),
                    rs.getString("description"),rs.getInt("apartment_number"),rs.getString("client_login"));
            orders.add(order);
        }
        return orders;
    }

    @Override
    public Order getEntityById(Integer id) throws SQLException {
        String sql = select +" where id = ?";
        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();
        Order order = null;
        while(rs.next())
        {
            order = new Order( Integer.parseInt(rs.getString("id")),
                    Integer.parseInt(rs.getString("payment")),
                    rs.getString("description"),rs.getInt("apartment_number"),rs.getString("client_login"));
        }
        return order;
    }

    @Override
    public void update(Order entity) throws SQLException {
        String sql = "UPDATE orders SET payment = ?, description = ? apartment_number = ? client_login = ? WHERE id = ?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1,entity.getPayment());
        ps.setString(2,entity.getDescription());
        ps.setInt(5,entity.getId());
        ps.setInt(3,entity.getApartment_number());
        ps.setString(4,entity.getClient_login());
        ps.executeUpdate();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String query = "delete from orders where id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public void create(Order entity) throws SQLException {
        String sql = "INSERT INTO orders (id, payment,  description,apartment_number, client_login) "
                +"VALUES (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,entity.getId());
        ps.setInt(2,entity.getPayment());
        ps.setString(3,entity.getDescription());
        ps.setInt(4,entity.getApartment_number());
        ps.setString(5,entity.getClient_login());
        ps.executeUpdate();
    }


}
