<%-- 
    Document   : login
    Created on : Apr 24, 2018, 2:24:46 PM
    Author     : martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/links.jsp" %>
        <title>Log ind</title>
    </head>
    <%@include file="includes/nav.jsp" %>
    <body>
        <div class="container">
            <h1 class="text-center">Log ind eller opret bruger</h1>

            <div class="col-lg-6">
                <h3>Login</h3>

                <form name="login" action="FrontController" method="POST">
                    <input class="form-control" type="hidden" name="command" value="login">
                    Email:<br>
                    <input class="form-control" type="text" name="email" value="someone@nowhere.com">
                    <br>
                    Password:<br>
                    <input class="form-control" type="password" name="password" value="sesam">
                    <br>
                    <input class="btn btn-primary" type="submit" value="Submit">
                </form>

            </div>

            <div class="col-lg-6">
                <h3>Opret bruger</h3>
                <form name="register" action="FrontController" method="POST">
                    <input class="form-control" type="hidden" name="command" value="register">
                    Email:<br>
                    <input class="form-control" type="text" name="email">
                    <br>
                    Name:<br>
                    <input class="form-control" type="text" name="name">
                    <br>
                    Address:<br>
                    <input class="form-control" type="text" name="address">
                    <br>
                    Phone:<br>
                    <input class="form-control" type="number" name="phone">
                    <br>
                    Password:<br>
                    <input class="form-control" type="password" name="password1">
                    <br>
                    Retype Password:<br>
                    <input class="form-control" type="password" name="password2">
                    <br>
                    <input class="btn btn-primary" type="submit" value="Submit">
                </form>
            </div>


            <% String error = (String) request.getAttribute("error");
                if (error != null) {%>
            <H2>Error!!</h2>
            <p><%= error%>
                <% }
                %>
        </div>
    </body>
</html>
