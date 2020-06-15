package app.controller.dao.entitiesDAO;

import app.controller.dao.AbstractController;
import app.controller.dao.DataSource.DataSource;
import app.model.entities.requisiiton.Requisition;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequisitionDAO implements AbstractController<Requisition,Integer> {
    private static final String select = "SELECT * FROM requisition";
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public RequisitionDAO() throws SQLException {
        //BasicDataSource bds = DataSource.getInstance().getBds();
        //connection = bds.getConnection();
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC","root","2910post");
    }


    @Override
    public List<Requisition> getAll() throws SQLException {
        ps = connection.prepareStatement(select);
        rs = ps.executeQuery();
        List<Requisition> requisitions = new ArrayList<Requisition>();
        while(rs.next())
        {
            Requisition requisition = new Requisition(Integer.parseInt(rs.getString("id"))
                    ,rs.getString("description"),rs.getInt("count_rooms"),rs.getInt("room_class"),rs.getString("arrival_date"),rs.getString("depature_date"),rs.getString("client_login"));
            requisitions.add(requisition);
        }
        return requisitions;
    }

    @Override
    public Requisition getEntityById(Integer id) throws SQLException {
        Requisition requisition = null;
        String sql = select +" where id = ?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
        rs = ps.executeQuery();
        if(rs.next())
        {
            requisition = new Requisition(Integer.parseInt(rs.getString("id"))
                    ,rs.getString("description"),rs.getInt("count_rooms"),rs.getInt("room_class"),rs.getString("arrival_date"),rs.getString("depature_date"),rs.getString("client_login"));

        }
        return requisition;
    }

    @Override
    public void update(Requisition entity) throws SQLException {
        String sql = "UPDATE requisition SET  description = ?,count_rooms = ?, room_class = ? , arrivalDate = ?, depatureDate = ? client_login = ? WHERE id = ?";
        ps = connection.prepareStatement(sql);
        ps.setString(1,entity.getDescription());
        ps.setInt(2,entity.getCount_rooms());
        ps.setInt(3,entity.getRoomClass());
        ps.setString(4,entity.getArrivalDate());
        ps.setString(5,entity.getDepartureDate());
        ps.setString(6,entity.getClient_login());
        ps.setInt(7,entity.getId());
        ps.executeUpdate();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String query = "delete from requisition where id = ?";
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setInt(1,id);
        preparedStmt.executeUpdate();
    }

    @Override
    public void create(Requisition entity) throws SQLException {
        String sql = "INSERT INTO requisition (description, arrival_date, depature_date, id, count_rooms, room_class,client_login) "
                +"VALUES (?,?,?,?,?,?,?)";
        ps = connection.prepareStatement(sql);
        ps.setString(1,entity.getDescription());
        ps.setString(2,entity.getArrivalDate());
        ps.setString(3,entity.getDepartureDate());
        ps.setInt(4,entity.getId());
        ps.setInt(5,entity.getCount_rooms());
        ps.setInt(6,entity.getRoomClass());
        ps.setString(7,entity.getClient_login());
        ps.executeUpdate();
    }
}
