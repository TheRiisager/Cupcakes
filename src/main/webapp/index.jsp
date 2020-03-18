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
        <input type="hidden" name="target" value="login">
        Email:<br>
        <input type="text" name="email" value="robin@somewhere.com">
        <br>
        Password:<br>
        <input type="password" name="pass" value="batman">
        <br>
        <br>
        <input type="submit" value="Submit" class="btn btn-primary">
    </form>
</td>


<%@ include file = "footer.inc" %>




