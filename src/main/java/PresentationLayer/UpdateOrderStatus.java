/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.requestException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juanni420
 */
public class UpdateOrderStatus extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, requestException
    {
        int orderId = Integer.parseInt(request.getParameter("id"));
        int currentStatus = Integer.parseInt(request.getParameter("status"));

        if (LogicFacade.UpdateOrderStatus(currentStatus + 1, orderId)) {
            return "employeepage";
        } else {
            return "error";
        }
    }

}
