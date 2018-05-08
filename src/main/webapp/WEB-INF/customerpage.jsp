<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.OrderEntity"%>
<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="nav.jsp" %>
        <% User user = (User) session.getAttribute("user");%>
        <h1 class="center top">Hello <%= user.getEmail()%> </h1>
        <div class="wrapper">
            <p class="center top">You are now logged in as a customer of our wonderful site.</p>
            <a class="button center" href="FrontController?command=order">Klik her får at komme til bestillingssiden</a>
            <a class="button center" href="FrontController?command=orders">Klik her får at se dine bestillinger</a>
        </div>
    </body>
</html>
