<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Login</title>
    </head>
    <body>
        <h4 class="display-4 text-center" style="margin-top:20px; margin-bottom: 20px">Iniciar sesión</h4>
        <div class="container" style="margin: 0 auto; width: 40%">
            <form method="post" action="Login">
                <div class="form-group">
                    <label>Username</label>
                    <input type="text" name="txtUsuario" class="form-control">
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" name="txtPassword" class="form-control">
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
            </form>
            <% if (request.getAttribute("mensajeError") != null && !request.getAttribute("mensajeError").equals("")) { %>
            <div class="container" style="margin-top: 20px">
                <p class="text-danger">${ mensajeError }</p>
            </div>
            <% }%>
        </div>
    </body>
</html>
