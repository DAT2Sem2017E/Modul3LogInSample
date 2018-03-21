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
        <h1>Hello <%= user.getEmail()%> </h1>
        <p>You are now logged in as a customer of our wonderful site.</p>
        <a class="button" href="FrontController?command=order"><p>Klik her får at komme til bestillingssiden</p></a>
        <a class="button" href="FrontController?command=orders"><p>Klik her får at se dine bestillinger</p></a>
    </body>
</html>
