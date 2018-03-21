<%-- 
    Document   : viewOrder
    Created on : Mar 21, 2018, 8:15:16 PM
    Author     : juanni420
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.OrderEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Order Page</title><link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="nav.jsp" %>
        <% OrderEntity order = (OrderEntity) session.getAttribute("singleorder");%>
        <h1>Here your can view and edit a single order</h1>
        <%out.println("<p><b>Order Id:</b> " + order.getId() + ", <b>Length:</b> " + order.getLength()
                        + ", <b>Width:</b> " + order.getLength() + ", <b>Height:</b> " + order.getHeight()
                        + ", <b>User Email:</b> " + order.getEmail() + ", <b>Status:</b> " + order.getStatus() + "</p>"); %>
    </body>
</html>
