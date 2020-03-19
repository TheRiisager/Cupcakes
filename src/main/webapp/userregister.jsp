<%--
  Created by IntelliJ IDEA.
  User: ckfol
  Date: 18-03-2020
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file = "header.inc" %>

<img src="img/logo.svg" height="120" width="300">

<td>
    <form name="register" action="FrontController" method="POST">
        <a class="text-white">Email:</a><br>
        <input type="text" name="email" value="robin@somewhere.com" required>
        <br>
        <a class="text-white">Password:</a><br>
        <input type="password" name="password1" value="" required>
        <br>
        <a class="text-white">Gentag Password:</a><br>
        <input type="password" name="password2" value="" required>
        <br>
        <br>
        <Button type="submit" class="btn btn-primary" name="target" value="register">Registrer</Button>
    </form>
    <br>
    <form name="index" action="FrontController" method="POST">
        <a class="text-white">Er Du Registreret?</a><br>
        <Button type="submit" class="btn btn-primary" name="target" value="index">Log Ind Her</Button>
    </form>
</td>


<%@ include file = "footer.inc" %>