<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: frede
  Date: 17-03-2020
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <c:forEach var="cupcake" items="${userOrderList}">
        ${cupcake.getName}
        ${cupcake.getPrice}<br>
    </c:forEach>

</head>
<body>

</body>
</html>
