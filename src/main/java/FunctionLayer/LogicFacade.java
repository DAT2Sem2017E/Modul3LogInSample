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

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static boolean createOrder(int width, int length, int roofId, int shedWidth, int shedLength, int userId, int status, boolean isConfirmed, String comments) {
        Order order = new Order(width, length, roofId, shedWidth, shedLength, userId, status, isConfirmed, comments);
        return OrderMapper.createOrder(order);
    }

    public static ArrayList<Roof> getFlatRoofs() {
        return RoofMapper.getFlatRoofs();
    }

}
