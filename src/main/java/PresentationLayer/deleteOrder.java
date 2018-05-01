/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.requestException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juanni420
 */
public class deleteOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, requestException {
        int orderId = Integer.parseInt(request.getParameter("id"));
        LogicFacade.deleteOrder(orderId);
        HttpSession session = request.getSession();
        ArrayList<Order> allOrders = LogicFacade.getOrders();
        session.setAttribute("orderList", allOrders);
        return "employeepage";
    }

}
