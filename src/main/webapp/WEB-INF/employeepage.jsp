<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page import="FunctionLayer.User"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/links.jsp" %>
        <title>Employee home page</title>
    </head>
    <%@include file="includes/nav.jsp" %>
    <% User user = (User) request.getSession().getAttribute("user");%>
    <%
        User customer = null;
        if (request.getAttribute("customer") != null) {
            customer = (User) request.getAttribute("customer");
        }
    %>
    <body>
        <div class="container">

            <h1>Hello <%= user.getName()%> </h1>
            You are now logged in as a EMPLOYEE of our wonderful site.

            <div class="container">
                <div class="row" style='float:left;'>
                    <a class="btn btn-primary" href="FrontController?command=orderList">Se Ordre</a>
                    <button value="Admin Varer" class="btn btn-primary">Tilføj Varer</button>
                    <button value="Admin Varer" class="btn btn-primary">Ændre Varer</button>
                </div>
            </div>
            <br>
            <br>
            <div class="row row1">
                <%
                    if (request.getSession().getAttribute("orderList") != null) {
                        ArrayList<Order> orders = (ArrayList<Order>) request.getSession().getAttribute("orderList");
                        //Collections.reverse(orders);
                %>

                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Bredde</th>
                            <th>Længde</th>
                            <th>Tag</th>
                            <th>Skur bredde</th>
                            <th>Skur længde</th>
                            <th>Bruger</th>
                            <th>Status</th>
                            <th></th>
                            <th>Kommentar</th>
                        </tr>
                    </thead>

                    <%int i = 0;
                        for (Order currOrder : orders) {%>
                    <tr>
                        <td><%=currOrder.getId()%></td>
                        <td><%=currOrder.getWidth()%></td>
                        <td><%=currOrder.getLength()%></td>
                        <td><%=currOrder.getRoof().getName()%></td>
                        <td><%=currOrder.getShedWidth()%></td>
                        <td><%=currOrder.getShedLength()%></td>
                        <td><a class="btn btn-primary" data-toggle="modal" data-target="#myModal<%=i%>"><%=currOrder.getUser().getName()%></a></td>
                        <td><%=currOrder.getStatusAsText()%></td>
                        <td><a class="btn btn-primary" href="FrontController?command=updateOrderStatus&id=<%=currOrder.getId()%>&status=<%=currOrder.getStatus()%>">Update Status</a></td>
                        <td><%=currOrder.getComment()%></td>
                        <td><a class="btn btn-primary" onclick="return confirm('Er du sikker?')" href="FrontController?command=deleteOrder&id=<%=currOrder.getId()%>">Delete Order</a></td>
                    </tr>
                    <div id="myModal<%=i%>" class="modal fade" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Bruger Info</h4>
                                </div>
                                <div class="modal-body">
                                    <p>Navn: <%=currOrder.getUser().getName()%> </p>
                                    <p>Email: <%=currOrder.getUser().getEmail()%></p>
                                    <p>Telefon: <%=currOrder.getUser().getPhone()%></p>
                                    <p>Addresse: <%=currOrder.getUser().getAddress()%></p>
                                    <p>By: <%=currOrder.getUser().getCity()%></p>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                            </div>

                        </div>
                    </div>
                    <%i++;
                            }
                        }%>

                </table>




            </div>
        </div>
    </body>
</html>
