<%-- 
    Document   : viewPieces
    Created on : Mar 22, 2018, 2:09:59 PM
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
        <title>View Pieces</title><link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="nav.jsp" %>
        <% OrderEntity order = (OrderEntity) session.getAttribute("piecesOrder");
            ArrayList<Side> sideList = (ArrayList) session.getAttribute("sideList");%>
        <h1 class="center top">Here you can see the pieces needed for your house</h1>
        <div class="wrapper">
            <p class="center"><b>Order</b></p>
            <%out.println("<p class='center'><b>Length:</b> " + order.getLength()
                        + ", <b>Width:</b> " + order.getWidth() + ", <b>Height:</b> " + order.getHeight() + "</p>");%>
                        <h2 class="top center">Styk liste</h2>           
            <table>
                <tr>
                    <td><b>Side</b></td>
                    <td>1x2</td>
                    <td>2x2</td>
                    <td>2x4</td>
                    <td>Dør</td>
                    <td>Vindue</td>
                </tr>
                <% int brick1sum = 0, brick2sum = 0, brick3sum = 0;
                    for (Side side : sideList) {
                        int brick1 = 0, brick2 = 0, brick3 = 0;
                        out.println("<tr><td><b>" + side.getName() + "</b></td>");
                        for (Brick brick : side.getBricks()) {
                            if (brick.getName().equals("1x2")) {
                                brick1++;
                                brick1sum++;
                            }
                            if (brick.getName().equals("2x2")) {
                                brick2++;
                                brick2sum++;
                            }
                            if (brick.getName().equals("2x4")) {
                                brick3++;
                                brick3sum++;
                            }
                        }
                        out.println("<td>" + brick1 + "</td>");
                        out.println("<td>" + brick2 + "</td>");
                        out.println("<td>" + brick3 + "</td>");
                        out.println("<td></td>");
                        out.println("<td></td>");

                    }
                %>

                <tr>
                    <td><b>ialt x højde</b></td>
                    <td><%= brick1sum * order.getHeight()%></td>
                    <td><%= brick2sum * order.getHeight()%></td>
                    <td><%= brick3sum * order.getHeight()%></td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
            <form class="center" name="goBack" action="FrontController" method="POST">
                <input type="hidden" name="command" value="orders">
                <input type="submit" value="Go Back" required>
            </form>       
        </div>
    </body>
</html>
