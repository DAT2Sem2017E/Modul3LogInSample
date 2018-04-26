/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import FunctionLayer.flatRoofRequestException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author martin
 */
public class flatRoofRequest extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws flatRoofRequestException {
        HttpSession session = request.getSession();
        
        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));
        int roofId = Integer.parseInt(request.getParameter("roof"));
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        int shedLength = Integer.parseInt(request.getParameter("shedLength"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String email = request.getParameter("email");
        String comments = request.getParameter("comments");
        int userId = 0;
        
        
        if(session.getAttribute("user") != null){
            User user = (User) session.getAttribute("user");
            userId = user.getId();
        }
        else{
            
        }
        return null;
        
        
    }
    
}
