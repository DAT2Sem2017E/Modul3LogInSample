<%-- 
    Document   : viewPieces
    Created on : Mar 22, 2018, 2:09:59 PM
    Author     : juanni420
--%>

<%@page import="FunctionLayer.OrderEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Pieces</title><link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="nav.jsp" %>
        <% OrderEntity order = (OrderEntity) session.getAttribute("piecesOrder"); %>
        <h1 class="center top">Here you can see the pieces needed for your house</h1>
        <div class="wrapper">
            <%out.println("<p><b>Length:</b> " + order.getLength()
                        + ", <b>Width:</b> " + order.getWidth() + ", <b>Height:</b> " + order.getHeight() + "</p>");%>

        </div>
    </body>
</html>
