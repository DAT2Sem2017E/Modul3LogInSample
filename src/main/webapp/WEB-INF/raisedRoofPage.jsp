<%-- 
    Document   : raisedRoofPage
    Created on : Apr 25, 2018, 10:56:02 AM
    Author     : martin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Roof"%>
<%@page import="FunctionLayer.Roof"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carport med rejsning</title>
        <%@include file="includes/links.jsp" %>
    </head>
    <%@include file="includes/nav.jsp" %>
    <body>
        <div class="container">
            <h2>QUICK-BYG TILBUD - CARPORT MED REJSNING</h2>
            <h4>
                Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning på en carport indenfor vores standardprogram, der tilpasses dine specifikke ønsker.</h4>
            <br>

            <h4>Tilbud og skitsetegning fremsendes med post hurtigst muligt.</h4>
            <h4>Ved bestilling medfølger standardbyggevejledning.</h4>
            <br>

            <h4><b>Udfyld nedenstående omhyggeligt og klik på "Bestil tilbud"</b></h4>


            <h5>Ønsket carport mål:</h5>
            <form action="FrontController" method="post">
                <input type="hidden" name="command" value="carportRequest">
                <input type="hidden" name="raisedOrFlat" value="raised">
                <label>Carport bredde</label>

                <select name="width" class="form-control">
                    <option value="0">Vælg bredde</option>
                    <option value="240">240 cm</option>
                    <option value="270">270 cm</option>
                    <option value="300">300 cm</option>
                    <option value="330">330 cm</option>
                    <option value="360">360 cm</option>
                    <option value="390">390 cm</option>
                    <option value="420">420 cm</option>
                    <option value="450">450 cm</option>
                    <option value="480">480 cm</option>
                    <option value="510">510 cm</option>
                    <option value="540">540 cm</option>
                    <option value="570">570 cm</option>
                    <option value="600">600 cm</option>
                    <option value="630">630 cm</option>
                    <option value="660">660 cm</option>
                    <option value="690">690 cm</option>
                    <option value="720">720 cm</option>
                    <option value="750">750 cm</option>
                </select>
                <label>Carport længde</label>
                <select name="length" class="form-control">
                    <option value="0">Vælg længde</option>
                    <option value="240">240 cm</option>
                    <option value="270">270 cm</option>
                    <option value="300">300 cm</option>
                    <option value="330">330 cm</option>
                    <option value="360">360 cm</option>
                    <option value="390">390 cm</option>
                    <option value="420">420 cm</option>
                    <option value="450">450 cm</option>
                    <option value="480">480 cm</option>
                    <option value="510">510 cm</option>
                    <option value="540">540 cm</option>
                    <option value="570">570 cm</option>
                    <option value="600">600 cm</option>
                    <option value="630">630 cm</option>
                    <option value="660">660 cm</option>
                    <option value="690">690 cm</option>
                    <option value="720">720 cm</option>
                    <option value="750">750 cm</option>
                    <option value="780">780 cm</option>
                </select>

                <label>Tag</label>
                <select name="roof" class="form-control">
                    <% ArrayList<Roof> roofs = (ArrayList<Roof>) request.getAttribute("roofs");
                        for (Roof roof : roofs) {


                    %>
                    <option value="<%=roof.getId()%>"><%=roof.getName()%></option>
                    <% }%>
                </select>

                <label>Taghældning</label>
                <select name="roofPitch" class="form-control">
                    <option value="15">15 grader</option>
                    <option value="20">20 grader</option>
                    <option value="25">25 grader</option>
                    <option value="30">30 grader</option>
                    <option value="35">35 grader</option>
                    <option value="40">40 grader</option>
                    <option value="45">45 grader</option>
                </select>

                <label>Redskabsrum:</label>
                <p>NB! Der skal beregnes 15 cm tagudhæng på hver side af redskabsrummet*</p>

                <label>Redskabsrum bredde</label>
                <select name="shedWidth" class="form-control">
                    <option value="0">Ønsker ikke redskabsrum</option>
                    <option value="210">210 cm</option>
                    <option value="240">240 cm</option>
                    <option value="270">270 cm</option>
                    <option value="300">300 cm</option>
                    <option value="330">330 cm</option>
                    <option value="360">360 cm</option>
                    <option value="390">390 cm</option>
                    <option value="420">420 cm</option>
                    <option value="450">450 cm</option>
                    <option value="480">480 cm</option>
                    <option value="510">510 cm</option>
                    <option value="540">540 cm</option>
                    <option value="570">570 cm</option>
                    <option value="600">600 cm</option>
                    <option value="630">630 cm</option>
                    <option value="660">660 cm</option>
                    <option value="690">690 cm</option>
                    <option value="720">720 cm</option>
                </select>

                <label>Redskabsrum længde</label>
                <select name="shedLength" class="form-control">
                    <option value="0">Ønsker ikke redskabsrum</option>
                    <option value="150">150 cm</option>
                    <option value="180">180 cm</option>
                    <option value="210">210 cm</option>
                    <option value="240">240 cm</option>
                    <option value="270">270 cm</option>
                    <option value="300">300 cm</option>
                    <option value="330">330 cm</option>
                    <option value="360">360 cm</option>
                    <option value="390">390 cm</option>
                    <option value="420">420 cm</option>
                    <option value="450">450 cm</option>
                    <option value="480">480 cm</option>
                    <option value="510">510 cm</option>
                    <option value="540">540 cm</option>
                    <option value="570">570 cm</option>
                    <option value="600">600 cm</option>
                    <option value="630">630 cm</option>
                    <option value="660">660 cm</option>
                    <option value="690">690 cm</option>
                </select>

                <hr>
                <%
                    if (request.getSession().getAttribute("user") == null) {
                %>
                <label>Navn</label>
                <input class="form-control" type="text" name="name">

                <label>Adresse</label>
                <input class="form-control" type="text" name="address">

                <label>Postnummer og by</label>
                <input class="form-control" type="text" name="city">

                <label>Telefon</label>
                <input class="form-control" type="number" name="phone">

                <label>Email adresse</label>
                <input class="form-control" type="text" name="email">


                <%}%>
                <label>Evt. bemærkninger</label>
                <textarea class="form-control" name="comments" rows="4" ></textarea>
                <br>
                <input class="btn btn-primary" type="submit" value="SEND FORSPØRGSEL">

                <br>
                <br>
            </form>


        </div>
    </body>
</html>
