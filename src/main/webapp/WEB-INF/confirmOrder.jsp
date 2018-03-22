<%-- 
    Document   : confirmOrder
    Created on : Mar 22, 2018, 1:13:20 PM
    Author     : juanni420
--%>

<%@page import="FunctionLayer.Brick"%>
<%@page import="FunctionLayer.Side"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.OrderEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Order</title>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="nav.jsp" %>
        <% OrderEntity order = (OrderEntity) session.getAttribute("singleOrder");
            ArrayList<Side> sideList = (ArrayList) session.getAttribute("sideList");%>
        <h1 class="center">Confirm Order</h1>
        <div class="wrapper">
            <%out.println("<p><b>Length:</b> " + order.getLength()
                        + ", <b>Width:</b> " + order.getWidth() + ", <b>Height:</b> " + order.getHeight() + "</p>");%>

            <% for (Side side : sideList) {
                    out.println("<p><b>Side: " + side.getName() + "</b></p>");
                    out.println("--------<b>Bricks</b>--------");
                    out.println("<br>");
                    for (Brick brick : side.getBricks()) {
                        out.println(brick.getName());
                    }
                    out.println("<br>");
                    out.println("------------------------");
                }
            %>

            <form name="createOrder" action="FrontController" method="POST">
                <input type="hidden" name="command" value="createOrder">
                <input type="submit" value="Confirm Order" required>
            </form>
            <form name="goBack" action="FrontController" method="POST">
                <input type="hidden" name="command" value="order">
                <input type="submit" value="Go Back" required>
            </form>       
        </div>
    </body>
</html>
