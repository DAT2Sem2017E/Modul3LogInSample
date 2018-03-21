package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }
    
    public static ArrayList<OrderEntity> getOrders(int userId) throws LoginSampleException {
        return OrderMapper.getOrders(userId);
    }
    
    public static ArrayList<OrderEntity> getEmployeeOrders() throws LoginSampleException {
        return OrderMapper.getEmployeeOrders();
    }
    
    public static boolean changeStatus(int orderId) throws LoginSampleException{
        return OrderMapper.changeStatus(orderId);
    }
    
    public static boolean createOrder(int width, int length, int height, int userId) throws LoginSampleException{
        return OrderMapper.createOrder(width, length, height, userId);
    }

}
