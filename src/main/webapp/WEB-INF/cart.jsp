<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: frede
  Date: 17-03-2020
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "header_normal.inc" %>

<div class="container w-75" style="margin-top: 25px;">
    <h1 class="display-2" style="color: white;">Dine bestillinger:</h1>
    <ul class="list-group list-group-flush">
    <c:forEach var="cupcake" items="${userOrderList}">
        <li class="list-group-item">${cupcake}kr.</li>
    </c:forEach>
        <li class="list-group-item font-weight-bold">Total - ${subtotal}kr.</li>
    </ul>

    <br>
    <form name="pay" action="FrontController" method="POST">
        <Button type="submit" class="btn btn-primary" name="target" value="ordercomplete" style="background-color: #C4556F; border-color: #C4556F">Betal med kredit</Button>
        <Button type="submit" class="btn btn-primary" name="target" value="ordercompletenopay" style="background-color: #C4556F; border-color: #C4556F">Betal i butikken</Button>
    </form>
</div>

<%@ include file = "footer_normal.inc" %>

