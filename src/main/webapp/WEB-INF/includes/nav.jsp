<%-- 
    Document   : nav
    Created on : Apr 23, 2018, 10:54:48 AM
    Author     : martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp">Fog</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="index.jsp">Hjem</a></li>
            <li><a href="FrontController?command=carportRequestPage">Quickbyg</a></li>
            <li><a href="#">Page 2</a></li>
            <li><a href="#">Page 3</a></li>

            <%
                if (request.getSession().getAttribute("role") != null) {
                    if (request.getSession().getAttribute("role").equals("employee")) {
            %>       
            <li><a href="FrontController?command=employeePage">Employee Page</a></li> 
                <%
                } else if (request.getSession().getAttribute("role").equals("customer")) {
                %>
            <li><a href="FrontController?command=customerPage">Customer Page</a></li> 
                <%
                        }
                    }
                %>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <%
                if (request.getSession().getAttribute("user") != null) {
            %>
            <li><a href="FrontController?command=logout">Log ud</a></li>
                <% } else {%>
            <li><a href="FrontController?command=loginPage">Log ind</a></li>
                <%}%>
        </ul>
    </div>
</nav>