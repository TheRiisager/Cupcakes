<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file = "header_normal.inc" %>
<div class="container w-75" style="margin-top: 25px;">

                <img src="img/logotest.svg" height="300" style="display: block; margin: 0 auto;">

        <form name="cupcakeselect" action="FrontController" method="POST">
        <div class="form-group" style="color: white;">
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


        <div class="form-group" style="color: white;">
                <label for="exampleFormControlSelect1">Vælg bunden af din cupcake her!</label>
                <select class="form-control" name="Cupcakebot" id="exampleFormControlSelect1">
                        <option>Chocolate</option>
                        <option>Vanilla</option>
                        <option>Nutmeg</option>
                        <option>Pistacio</option>
                        <option>Almond</option>
                </select>
        </div>
                <Button type="submit" class="btn btn-primary" name="target" value="addItem" style="background-color: #C4556F; border-color: #C4556F">Føj til bestilling</Button>
        </form>
</div>

<%@ include file = "footer_normal.inc" %>

