<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

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
    <body>
        <div class="container">

            <h1>Hello <%=request.getSession().getAttribute("email")%> </h1>
            You are now logged in as a EMPLOYEE of our wonderful site.

            <div class="container">
                <div class="row">
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
                %>

                <table style="width:100%;">
                    <tr>
                        <th>ID</th>
                        <th>Width</th>
                        <th>Length</th>
                        <th>roof ID</th>
                        <th>Shed width</th>
                        <th>Shed length</th>
                        <th>User ID</th>
                        <th>Status</th>
                        <th>Comment</th>
                    </tr>


                    <%for (Order currOrder : orders) {%>
                    <tr>
                        <td><%=currOrder.getId()%></td>
                        <td><%=currOrder.getWidth()%></td>
                        <td><%=currOrder.getLength()%></td>
                        <td><%=currOrder.getRoofId()%></td>
                        <td><%=currOrder.getShedWidth()%></td>
                        <td><%=currOrder.getShedLength()%></td>
                        <td><%=currOrder.getUserId()%></td>
                        <td><%=currOrder.getStatus()%></td>
                        <td><%=currOrder.getComment()%></td>
                    </tr>
                    <%}
                        }%>

                </table>
            </div>
        </div>
    </body>
</html>
