/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderEntity;
import FunctionLayer.Side;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juanni420
 */
public class confirmOrder extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        OrderEntity singleOrder = new OrderEntity(height, length, width);
        session.setAttribute("singleOrder", singleOrder);
        
        //her skal der også udregnes lego klodser og give listen med i session
        ArrayList<Side> sidesList = LogicFacade.getBricks(width, length, height);
        session.setAttribute("sideList", sidesList);
        
        return "confirmOrder";
    }
    
}
