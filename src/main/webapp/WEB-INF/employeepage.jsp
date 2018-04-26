<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

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

            <h1>Hello <%=request.getSession().getAttribute("email")%> </h1>
            You are now logged in as a EMPLOYEE of our wonderful site.

            <div class="container">
                <div class="row">
                    <button value="Se Ordre" class="btn btn-primary">Se Ordre</button>
                    <button value="Admin Varer" class="btn btn-primary">Tilføj Varer</button>
                    <button value="Admin Varer" class="btn btn-primary">Ændre Varer</button>
                </div>
            </div>
        </div>
    </body>
</html>
