<%-- 
    Document   : index
    Created on : 30/10/2020, 18:46:46
    Author     : Emiliano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Inicio</title>
    </head>
    <body>
        <h4 class="display-4 text-center" style="margin-top:20px">Iniciar sesión</h4>
        <div class="container">
            <form>
                <div class="form-group">
                  <label>Username</label>
                  <input type="email" name="username" class="form-control">
                </div>
                <div class="form-group">
                  <label>Password</label>
                  <input type="password" name="password" class="form-control">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </body>
</html>
