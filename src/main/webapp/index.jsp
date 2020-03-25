<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file = "header.inc" %>

<img src="img/logotest.svg" height="200">

<td>
    <form name="login" action="FrontController" method="POST">
        <a class="text-white">Email:</a><br>
        <input type="text" name="email" value="lars@somewhere.com" required>
        <br>
        <a class="text-white">Password:</a><br>
        <input type="password" name="password1" value="42069" required>
        <br>
        <br>
        <Button type="submit" class="btn btn-primary" name="target" value="login" style="background-color: #C4556F; border-color: #C4556F">Log Ind</Button>
    </form>
    <br>
    <form name="userregister" action="FrontController" method="POST">
        <Button type="submit" class="btn btn-link" name="target" value="userregister" style="text-decoration: none; color: lightgray; text-align: left; padding: 0;">Ikke registreret?<br>Registrer Her</Button>
    </form>
</td>

<%@ include file = "footer.inc" %>