<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file = "header_normal.inc" %>

<div class="container w-75">
    <h1 class="display-2" style="color: white;">VELKOMMEN ${sessionScope.email}</h1>

    <ul class="list-group list-group-flush">
        <c:forEach var="order" items="${orderList}">
            <li class="list-group-item">${order}</li>
        </c:forEach>
    </ul>

    <form name="deleteOrder" action="FrontController" method="POST">
        <input type="text" name="orderID" value="0" required>
        <br>
        <br>
        <Button type="submit" class="btn btn-primary" name="target" value="deleteOrder" style="background-color: #C4556F; border-color: #C4556F">Slet</Button>
    </form>

</div>





<%@ include file = "footer_normal.inc" %>