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

/**
 *
 * @author martin
 */
public class OrderMapper {

    public static boolean createOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Fetches every order from the database and returns them in an ArrayList ordered descending by id.
     * @return ArrayList
     */
    public static ArrayList<Order> getOrders() {
        
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
                int status = rs.getInt("isConfirmed");
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
    
}
