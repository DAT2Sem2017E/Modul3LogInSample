<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome page</title>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="WEB-INF/nav.jsp" %>
        <h1 class="center top">Welcome to LegoHouse</h1>
        <div class="wrapper">
            <p class="center top">This is the front page of my Lego House site.</p>
            <!-- write 'command....&t=2' to send 2 commands to the FrontController with the link -->
            <a class="button center" href="FrontController?command=help">Få hjælp til din bestilling</a>

            <% String error = (String) request.getAttribute("error");
            if (error != null) {%>
            <H2 class="center">Error!!</h2>
            <p><%= error%>
                <% }
                %>
        </div>
    </body>
</html>
