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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juanni420
 */
public class createOrder extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        OrderEntity order = (OrderEntity) session.getAttribute("singleOrder");
        int userId = user.getId();
        int length = order.getLength();
        int width = order.getWidth();
        int height = order.getHeight();
        LogicFacade.createOrder(width, length, height, userId);
        return user.getRole() + "page";
    }
    
}
