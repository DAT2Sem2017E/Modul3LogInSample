<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="nav.jsp" %>
        <% User user = (User) session.getAttribute("user");%>
        <h1 class="top center">Hello <%= user.getEmail()%> </h1>
        <div class="wrapper">
            <p class="center top">You are now logged in as a EMPLOYEE of our wonderful site.</p>
            <a class="button center" href="FrontController?command=emporders">Klik her får at se alle bestillinger</a>
        </div>

    </body>
</html>
