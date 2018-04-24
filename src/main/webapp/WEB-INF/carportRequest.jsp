<%-- 
    Document   : carportRequest
    Created on : Apr 24, 2018, 2:41:11 PM
    Author     : martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quickbyg</title>
        <%@include file="includes/links.jsp" %>
    </head>
    <%@include file="includes/nav.jsp" %>
    <body>
        <div class="container">

            <h1>Quickbyg</h1>

            <p>Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning på en carport indenfor vores standardprogram, der tilpasses dine specifikke ønsker.</p>

            <p>Tilbud og skitsetegning fremsendes med post hurtigst muligt.</p>
            <p>Ved bestilling medfølger standardbyggevejledning.</p>

            <p>Rekvirér tilbud - start med at vælge type:</p>

            <h3><a href="FrontController?command=flatRoofPage">Carport med fladt tag</a></h1>
                <br>
                <h3><a href="FrontController?command=raisedRoofPage">Carport med rejsning</a></h3>

        </div>
    </body>
</html>
