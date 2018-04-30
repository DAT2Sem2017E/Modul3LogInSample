/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import FunctionLayer.requestException;

/**
 *
 * @author martin
 */
public class OrderMapper
{

    public static boolean createOrder(Order order) throws requestException
    {
        try {
            Connection conn = Connector.connection();
            String SQL = "INSERT INTO `Fog-CarportsDB`.`orders` (`width`, `length`, `fkRoofId`, `roofPitch`, `shedWidth`, `shedLength`, `fkUserId`, `status`, `comments`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, order.getWidth());
            ps.setInt(2, order.getLength());
            ps.setInt(3, order.getRoofId());
            ps.setInt(4, order.getRoofPitch());
            ps.setInt(5, order.getShedWidth());
            ps.setInt(6, order.getShedLength());
            ps.setInt(7, order.getUserId());
            ps.setInt(8, order.getStatus());
            ps.setString(9, order.getComments());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException exception) {
            throw new requestException(exception.getMessage());
        }
    }

    /**
     * Fetches every order from the database and returns them in an ArrayList
     * ordered descending by id.
     *
     * @return ArrayList
     */
    public static ArrayList<Order> getOrders()
    {

        try {
            ArrayList<Order> orders = new ArrayList<>();
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM orders ORDER BY id DESC";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int width = rs.getInt("width");
                int length = rs.getInt("length");
                int roofId = rs.getInt("fkRoofId");
                int shedWidth = rs.getInt("shedWidth");
                int shedlength = rs.getInt("shedLength");
                int userId = rs.getInt("fkUserId");
                int status = rs.getInt("status");
                String comment = rs.getString("comments");

                orders.add(new Order(id, width, length, roofId, shedWidth, shedlength, userId, status, comment));

            }

            return orders;
        } catch (ClassNotFoundException | SQLException e) {

            //TODO: Custom exception
            e.printStackTrace();
            return null;
        }
    }

    public static boolean updateOrderStatus(int newStatus, int id)
    {
        try {
            Connection conn = Connector.connection();
            String SQL = "UPDATE orders SET status = " + newStatus + " WHERE id = " + id;
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.executeUpdate();
            return true;
            
        } catch (ClassNotFoundException | SQLException e) {

            //TODO: Custom exception
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean deleteOrder(int id) throws requestException{
        
        try {
            Connection conn = Connector.connection();
            String SQL = "DELETE FROM Fog-CarportsDB.orders WHERE orders.id =? ";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException exception) {
            throw new requestException(exception.getMessage());
        }
        
    }
}
