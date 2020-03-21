<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file = "header.inc" %>

            <img src="img/logo.svg" height="120" width="300">

<td>
    <form name="login" action="FrontController" method="POST">
        <a class="text-white">Email:</a><br>
        <input type="text" name="email" value="lars@somewhere.com" required>
        <br>
        <a class="text-white">Password:</a><br>
        <input type="password" name="password1" value="42069" required>
        <br>
        <Button type="submit" class="btn btn-primary" name="target" value="login">Log Ind</Button>
    </form>
    <br>
    <form name="userregister" action="FrontController" method="POST">
        <a class="text-white">Ikke registreret?</a><br>
        <Button type="submit" class="btn btn-primary" name="target" value="userregister">Registrer Her</Button>
    </form>
</td>


<%@ include file = "footer.inc" %>


