<%-- 
    Document   : success
    Created on : Apr 26, 2018, 9:39:39 AM
    Author     : martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success</title>
        <%@include file="includes/links.jsp" %>
    </head>
    <%@include file="includes/nav.jsp" %>
    <body>
        <div class="container">
            <h1 class="text-center">Din forspørgsel er modtaget!</h1>
            
            <%
            if (session.getAttribute("svgSide") != null) {
            %>
            <svg width="75%" viewBox="0 0 30000 30000">
            <%=request.getSession().getAttribute("svgSide")%>
            </svg>
            <%
            }
            %>

            <br>
            <br>
            <br>
            
            <%
            if (session.getAttribute("svgTop") != null) {
            %>
            <svg width="75%" viewBox="0 0 30000 30000">
            <%=request.getSession().getAttribute("svgTop")%>
            </svg>
            <%
            }
            %>
        </div>
    </body>
</html>
