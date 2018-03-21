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
        <h1>Welcome to the order page!</h1>
        
        <table>
            <tr><td>Order</td>
                <td>
                    <form name="order" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="order">
                        Length:<br>
                        <input type="number" name="length">
                        <br> 
                        Width:<br>
                        <input type="number" name="width">
                        <br>
                        Height:<br>
                        <input type="number" name="hegiht">
                        <br>
                       
                        <input type="submit" value="Submit">
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
