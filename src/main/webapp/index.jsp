<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file = "header.inc" %>

            <img src="img/logo.svg" height="120" width="300">

            <form>
                <input type="hidden" name="taget" value="login">
                <div class="form-group">
                    <label for="exampleInputEmail1" style="color:white;">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1" style="color:white;">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                </div>
                <button type="submit" class="btn btn-primary" style="color:black; background-color:#f0e940; border-color:#f0e940;">Submit</button>
            </form>


<%@ include file = "footer.inc" %>




