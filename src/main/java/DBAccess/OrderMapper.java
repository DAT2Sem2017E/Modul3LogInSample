/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderEntity;
import FunctionLayer.OrderException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author juanni420
 */
public class OrderMapper {

    public static ArrayList<OrderEntity> getOrders(int userId) throws OrderException {
        ArrayList<OrderEntity> orderList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT Orders.Order_Id, Orders.Length, Orders.Width, "
                    + "Orders.Height, Orders.Status FROM LegoDB.Orders"
                    + " inner join LegoDB.Users on LegoDB.Orders.User_Id = LegoDB.Users.id "
                    + "where Orders.User_Id =? order by Orders.Order_Id";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Order_Id");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                String status = rs.getString("status");
                OrderEntity order = new OrderEntity(id, height, length, width, status);
                orderList.add(order);
            }
            return orderList;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public static ArrayList<OrderEntity> getEmployeeOrders() throws OrderException {
        ArrayList<OrderEntity> orderList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT Orders.Order_Id, Orders.Height, Orders.Length, "
                    + "Orders.Width, Orders.Status, Users.email FROM LegoDB.Orders"
                    + " inner join LegoDB.Users on LegoDB.Orders.User_Id = LegoDB.Users.id order by Orders.Order_Id;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Order_Id");
                int width = rs.getInt("width");
                int length = rs.getInt("length");
                int height = rs.getInt("height");
                String status = rs.getString("status");
                String email = rs.getString("email");
                OrderEntity order = new OrderEntity(id, height, length, width, status, email);
                orderList.add(order);
            }
            return orderList;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public static OrderEntity getOrder(int orderId) throws OrderException {
        OrderEntity order = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT Orders.Order_Id, Orders.Length, Orders.Width, "
                    + "Orders.Height FROM LegoDB.Orders where Orders.Order_Id =?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                order = new OrderEntity(height, length, width);
            }
            return order;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public static boolean changeStatus(int orderId) throws OrderException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE LegoDB.Orders SET Orders.status = 'Afsendt' "
                    + "where Orders.Order_Id =?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderId);
            ps.executeUpdate();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public static boolean createOrder(int width, int length, int height, int userId) throws OrderException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Orders (length, width, height, user_id) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, length);
            ps.setInt(2, width);
            ps.setInt(3, height);
            ps.setInt(4, userId);
            ps.executeUpdate();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

}
