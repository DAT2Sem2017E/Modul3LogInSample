/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Roof;
import FunctionLayer.flatRoofRequestException;
import com.mysql.cj.api.mysqla.result.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author martin
 */
public class RoofMapper {

    public static ArrayList<Roof> getFlatRoofs() {
        ArrayList<Roof> roofs = null;
        try {
            roofs = new ArrayList<>();
            Connection conn = Connector.connection();
            String SQL = "SELECT * FROM roof WHERE forRaisedRoof = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setBoolean(1, false);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                boolean forRaisedRoof = rs.getBoolean("forRaisedRoof");
                roofs.add(new Roof(id, name, price, forRaisedRoof));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }
        return roofs;

    }

}

//public static ArrayList<Order> getUsersOrders(int userId) throws LoginSampleException {
//        try {
//            ArrayList<Order> orders = new ArrayList<>();
//            Connection conn = Connector.connection();
//            String SQL = "SELECT * FROM Orders WHERE fk_userId = ?";
//            PreparedStatement ps = conn.prepareStatement(SQL);
//            ps.setInt(1, userId);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                int length = rs.getInt("length");
//                int width = rs.getInt("width");
//                int height = rs.getInt("height");
//                int status = rs.getInt("status");
//                boolean door = rs.getBoolean("door");
//                boolean window = rs.getBoolean("window");
//                orders.add(new Order(id, length, width, height, userId, status, door, window));
//
//            }
//            return orders;
//
//        } catch (ClassNotFoundException | SQLException ex) {
//            throw new LoginSampleException(ex.getMessage());
//        }
//
//    }

