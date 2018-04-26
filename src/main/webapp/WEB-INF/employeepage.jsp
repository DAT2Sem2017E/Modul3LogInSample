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

            <h1>Hello <%=request.getParameter("email")%> </h1>
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
                    if(request.getSession().getAttribute("orderList") != null) {
                        ArrayList<Order> orders = (ArrayList<Order>)request.getSession().getAttribute("orderList");

                        out.print("<table style=\"width:100%\">");
                        out.print("<tr>");
                        out.print("<th>ID</th>");
                        out.print("<th>Width</th>");
                        out.print("<th>Length</th>");
                        out.print("<th>roof ID</th>");
                        out.print("<th>Shed width</th>");
                        out.print("<th>Shed length</th>");
                        out.print("<th>User ID</th>");
                        out.print("<th>Status</th>");
                        out.print("</tr>");
                        
                        
                        for (Order currOrder: orders) {

                            out.print("<tr>");
                            out.print("<td>" + currOrder.getId() +"</td>");
                            out.print("<td>" + currOrder.getWidth() +"</td>");
                            out.print("<td>" + currOrder.getLength() +"</td>");
                            out.print("<td>" + currOrder.getRoofId() +"</td>");
                            out.print("<td>" + currOrder.getShedWidth() +"</td>");
                            out.print("<td>" + currOrder.getShedLength() +"</td>");
                            out.print("<td>" + currOrder.getUserId() +"</td>");
                            out.print("<td>" + currOrder.getStatus() +"</td>");
                            out.print("</tr>");
                        }
                    }
                %>
            </div>
        </div>
    </body>
</html>
