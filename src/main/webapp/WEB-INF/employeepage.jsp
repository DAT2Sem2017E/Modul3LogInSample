<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page import="FunctionLayer.User"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/links.jsp" %>
        <title>Employee home page</title>
    </head>
    <%@include file="includes/nav.jsp" %>
    <% User user = (User) request.getSession().getAttribute("user");%>
    <body>
        <div class="container">

            <h1>Hello <%= user.getName() %> </h1>
            You are now logged in as a EMPLOYEE of our wonderful site.

            <div class="container">
                <div class="row" style='float:left;'>
                    <a class="btn btn-primary" href="FrontController?command=orderList">Se Ordre</a>
                    <button value="Admin Varer" class="btn btn-primary">Tilføj Varer</button>
                    <button value="Admin Varer" class="btn btn-primary">Ændre Varer</button>
                </div>
            </div>
            <br>
            <br>
            <div class="row row1">
                <%
                    if (request.getSession().getAttribute("orderList") != null) {
                        ArrayList<Order> orders = (ArrayList<Order>) request.getSession().getAttribute("orderList");
                        //Collections.reverse(orders);
                %>

                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Bredde</th>
                            <th>Længde</th>
                            <th>Tag</th>
                            <th>Skur bredde</th>
                            <th>Skur længde</th>
                            <th>Bruger</th>
                            <th>Status</th>
                            <th></th>
                            <th>Kommentar</th>
                        </tr>
                    </thead>

                    <%for (Order currOrder : orders) {%>
                    <tr>
                        <td><%=currOrder.getId()%></td>
                        <td><%=currOrder.getWidth()%></td>
                        <td><%=currOrder.getLength()%></td>
                        <td><%=currOrder.getRoofId()%></td>
                        <td><%=currOrder.getShedWidth()%></td>
                        <td><%=currOrder.getShedLength()%></td>
                        <td><%=currOrder.getUserId()%></td>
                        <td><%=currOrder.getStatusAsText()%></td>
                        <td><a class="btn btn-primary" href="FrontController?command=updateOrderStatus&id=<%=currOrder.getId()%>&status=<%=currOrder.getStatus()%>">Update Status</a></td>
                        <td><%=currOrder.getComment()%></td>
                        <td><a class="btn btn-primary" onclick="return confirm('Er du sikker?')" href="FrontController?command=deleteOrder&id=<%=currOrder.getId()%>">Delete Order</a></td>
                    </tr>
                    <%}
                        }%>

                </table>
            </div>
        </div>
    </body>
</html>
