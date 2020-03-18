<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file = "header_normal.inc" %>

        <h1>Hello ${sessionScope.email} </h1>





        You are now logged in as a customer of our wonderful site.
<%@ include file = "footer_normal.inc" %>
