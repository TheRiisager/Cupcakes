<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file = "header_normal.inc" %>
<div class="container w-75">
        <div class="form-group">
                <label for="exampleFormControlSelect1">Vælg toppen på din cupcake her!</label>
                <select class="form-control" name="Cupcaketop" id="exampleFormControlSelect1">
                        <option>Chocolate</option>
                        <option>Blueberry</option>
                        <option>Raspberry</option>
                        <option>Crispy</option>
                        <option>Strawberry</option>
                        <option>Rum/Raisin</option>
                        <option>Orange</option>
                        <option>Lemon</option>
                        <option>Blue cheese</option>
                </select>
        </div>


        <div class="form-group">
                <label for="exampleFormControlSelect1">Vælg bunden af din cupcake her!</label>
                <select class="form-control" name="Cupcakebot" id="exampleFormControlSelect1">
                        <option value="1">Chocolate</option>
                        <option value="2">Vanilla</option>
                        <option value="3">Nutmeg</option>
                        <option value="4">Pistacio</option>
                        <option value="5">Almond</option>
                </select>
        </div>

        <input class="btn btn-primary" type="submit" value="Submit">
</div>

<%@ include file = "footer_normal.inc" %>

