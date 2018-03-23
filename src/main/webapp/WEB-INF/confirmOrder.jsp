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
            <p class="center"><b>Order</b></p>
            <%out.println("<p class='center'><b>Length:</b> " + order.getLength()
                        + ", <b>Width:</b> " + order.getWidth() + ", <b>Height:</b> " + order.getHeight() + "</p>");%>
            <p class="center"><b>The door and window are both 2 dots wide</b></p>
            <p class="center"><b>The door is 3 bricks high; The window is 1 brick high.</b></p>
            <p class="center">If you'll notice am i only subtracting the door and window height from <b>2x2</b> bricks.
                That's because both the window and door is 2 dots wide, so we've swapped 4 <b>2x2</b> bricks in place for the door and window.</p>
            <h2 class="top center">Styk liste</h2>           
            <table>
                <tr>
                    <td><b>Side</b></td>
                    <td>1x2</td>
                    <td>2x2</td>
                    <td>2x4</td>
                    <td>Dør</td>
                    <td>Vindue</td>
                    <% int brick1sum = 0, brick2sum = 0, brick3sum = 0;
                        int door = 0, window = 0, doorheight = 0, windowheight = 0;
                        for (Side side : sideList) {
                            int brick1 = 0, brick2 = 0, brick3 = 0;
                            door = 0;
                            window = 0;
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
                                if (brick.getName().equals("Door")) {
                                    door++;
                                    doorheight = brick.getHeight();
                                }
                                if (brick.getName().equals("Window")) {
                                    window++;
                                    windowheight = brick.getHeight();
                                }
                            }
                            out.println("<td>" + brick1 + "</td>");
                            out.println("<td>" + brick2 + "</td>");
                            out.println("<td>" + brick3 + "</td>");
                            out.println("<td>" + door + "</td>");
                            out.println("<td>" + window + "</td>");

                        }
                    %>

                <tr>
                    <td><b>(ialt x H) - dørH - vindueH</b></td>
                    <td><%= (brick1sum * order.getHeight())%></td>
                    <td><%= (brick2sum * order.getHeight() - doorheight - windowheight)%></td>
                    <td><%= (brick3sum * order.getHeight())%></td>
                </tr>
            </table>
            <form class="center" name="createOrder" action="FrontController" method="POST">
                <input type="hidden" name="command" value="createOrder">
                <input type="submit" value="Confirm Order" required>
            </form>
            <form class="center" name="goBack" action="FrontController" method="POST">
                <input type="hidden" name="command" value="order">
                <input type="submit" value="Go Back" required>
            </form>       
        </div>
    </body>
</html>
