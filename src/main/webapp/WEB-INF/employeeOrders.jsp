<%-- 
    Document   : employeeOrders
    Created on : Mar 21, 2018, 7:36:41 PM
    Author     : juanni420
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.OrderEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Orders Page</title>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="nav.jsp" %>
        <% ArrayList<OrderEntity> ordersList = (ArrayList) session.getAttribute("emporders");
        %>
        <h1 class="top center">Here you can view all orders</h1>                
        <div class="wrapper">
            <% for (OrderEntity order : ordersList) {
                    out.println("<p><b>Order Id:</b> " + order.getId() + ", <b>Length:</b> " + order.getLength()
                            + ", <b>Width:</b> " + order.getWidth() + ", <b>Height:</b> " + order.getHeight()
                            + ", <b>User Email:</b> " + order.getEmail() + ", <b>Status:</b> " + order.getStatus() + "</p>");
                }
            %>
            <h2 class="center">Change order status below</h2>
            <form name="changeStatus" class="center" action='FrontController' method='post'>
                <input type="hidden" name="command" value="changeStatus">
                <select name="orderId">
                    <% for (OrderEntity order : ordersList) {
                            out.println("<option value='" + order.getId() + "'>" + "Order id: " + order.getId() + "</option>");
                        }%>
                </select>
                <input type="submit" value="Change Status to Sent">
            </form>
            <a class="button center" href="FrontController?command=emporders">Refresh</a>
        </div>
    </body>
</html>
