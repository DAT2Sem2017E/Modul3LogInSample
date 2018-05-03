package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import DBAccess.RoofMapper;
import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password, String name, String address, int phone, String city) throws LoginSampleException
    {
        User user = new User(email, password, "customer", address, name, phone, city);
        UserMapper.createUser(user);
        return user;
    }

    public static boolean createOrder(int width, int length, int roofId, int roofPitch, int shedWidth, int shedLength, int userId, int status, String comments) throws requestException {
        Order order = new Order(width, length, roofId, roofPitch, shedWidth, shedLength, userId, status, comments);
        return OrderMapper.createOrder(order);
    }

    public static ArrayList<Roof> getFlatRoofs() {
        return RoofMapper.getFlatRoofs();
    }
    public static ArrayList<Roof> getRaisedRoofs() {
        return RoofMapper.getRaisedRoofs();
    }
    
    /**
     * fetches all orders from database
     * @return 
     */
    public static ArrayList<Order> getOrders() {
        return OrderMapper.getOrders();
    }
    
    public static boolean deleteOrder(int id) throws requestException{
        return OrderMapper.deleteOrder(id);
    }

    public static boolean UpdateOrderStatus(int status, int orderId)
    {
        return OrderMapper.updateOrderStatus(status, orderId);
    }
}
