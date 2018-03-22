<%-- 
    Document   : order
    Created on : Mar 21, 2018, 1:33:17 PM
    Author     : juanni420
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="nav.jsp" %>
        <h1 class="center top">Welcome to the order page!</h1>
        <table style="max-width: 40%; margin: auto;">
            <tr><td>Order</td>
                <td>
                    <form name="confirmOrder" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="confirmOrder">
                        Length:<br>
                        <input style="width: 170px;" type="number" name="length" min="10" max="100" step="1" required>
                        <br> 
                        Width:<br>
                        <input style="width: 170px;" type="number" name="width" min="10" max="100" step="1" required>
                        <br>
                        Height:<br>
                        <input style="width: 170px;" type="number" name="height" min="4" max="15" step="1" required>
                        <br>
                       
                        <input type="submit" value="Submit" required>
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
