package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;

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
    
    public static boolean createOrder(int width, int length, int roofId, int shedWidth, int shedLength, int userId, int status){
        Order order = new Order(width, length, roofId, shedWidth, shedLength, userId, status);
        return OrderMapper.createOrder(order);
        
        
    }

}
