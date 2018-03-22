<%-- 
    Document   : nav
    Created on : Mar 21, 2018, 2:10:44 PM
    Author     : juanni420
--%>

<%@page import="FunctionLayer.User"%>
<form class="nav" style="margin: 0;" action='logOut' method='post'>
    <nav>
        <a href="index.jsp">Front Page</a>

        <% if (session.getAttribute("user") != null) {
                if (session.getAttribute("role").equals("customer")) {
                    out.println("<a href='FrontController?command=order'>Order LegoHouse</a>");
                }
                out.println("<a href='FrontController?command=" + session.getAttribute("role")
                        + "'>" + session.getAttribute("role") + "</a>");
                out.println("<a href='FrontController?command=logout'>Log Out</a>");
            }
        else{
            out.println("<a href='FrontController?command=login'>Login</a>");
}%>

        <a href="FrontController?command=help">Help</a>

    </nav>
</form>
