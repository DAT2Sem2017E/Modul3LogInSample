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
import FunctionLayer.Side;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juanni420
 */
public class viewPieces extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        HttpSession session = request.getSession();
        OrderEntity order = LogicFacade.getOrder(orderId);
        int width = order.getWidth();
        int length = order.getLength();
        int height = order.getHeight();
        ArrayList<Side> sidesList = LogicFacade.getBricks(width, length, height);
        session.setAttribute("sideList", sidesList);
        session.setAttribute("piecesOrder", order);
        return "viewPieces";
    }
    
}
