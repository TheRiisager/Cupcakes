<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file = "header_normal.inc" %>

<h1 class="text-center text-white">VELKOMMEN ${sessionScope.email}</h1>

<div class="card m-5">
    <h5 class="card-header">Lars' Fødselsdag</h5>
    <div class="card-body">
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="#" class="btn btn-primary m-1">Bestil</a>
        <a href="#" class="btn btn-primary m-1">Rediger</a>
        <a href="#" class="btn btn-primary m-1">Slet</a>
    </div>
</div>


<%@ include file = "footer_normal.inc" %>