<%-- 
    Document   : login
    Created on : Mar 22, 2018, 8:38:17 AM
    Author     : juanni420
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="nav.jsp" %>
        <div class="top">
            <h1 class="center">Login Page</h1>
        <% if (session.getAttribute("user") == null) {
        %>
        <table>
            <tr><td>Login</td>
                <td>
                    <form name="login" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="Login">
                        Email:<br>
                        <input type="text" name="email" value="jens@somewhere.com">
                        <br>
                        Password:<br>
                        <input type="password" name="password" value="jensen">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
                <td>Or Register</td>
                <td>
                    <form name="register" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="register">
                        Email:<br>
                        <input type="text" name="email" value="">
                        <br>
                        Password:<br>
                        <input type="password" name="password1" value="">
                        <br>
                        Retype Password:<br>
                        <input type="password" name="password2" value="">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
            </tr>
        </table>
        <%
            } else {
                out.println("<p>Du er logget ind og klar til at bestille Lego!</p>");
            }%>

        <!-- write 'command....&t=2' to send 2 commands to the FrontController with the link -->
        <a class="button center" href="FrontController?command=help">Få hjælp til din bestilling</a>
        </div>
    </body>
</html>
