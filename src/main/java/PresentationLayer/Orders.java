/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderEntity;
import FunctionLayer.OrderException;
import FunctionLayer.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juanni420
 */
public class Orders extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderException {
        ArrayList<OrderEntity> orderList =  new ArrayList<>();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getId();
        orderList = LogicFacade.getOrders(userId);
        session.setAttribute("orders", orderList);  
        return "orders";
    }
    
}
