/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Order;
import FunctionLayer.requestException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author martin
 */
public class OrderMapper {

    public static boolean createOrder(Order order) throws requestException {
        try {
            Connection conn = Connector.connection();
            String SQL = "INSERT INTO `Fog-CarportsDB`.`orders` (`width`, `length`, `fkRoofId`, `roofPitch`, `shedWidth`, `shedLength`, `fkUserId`, `isConfirmed`, `comments`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, order.getWidth());
            ps.setInt(2, order.getLength());
            ps.setInt(3, order.getRoofId());
            ps.setInt(4, order.getRoofPitch());
            ps.setInt(5, order.getShedWidth());
            ps.setInt(6, order.getShedLength());
            ps.setInt(7, order.getUserId());
            ps.setBoolean(8, order.getIsConfirmed());
            ps.setString(9, order.getComments());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException exception) {
            throw new requestException(exception.getMessage());
        }
    }

}
