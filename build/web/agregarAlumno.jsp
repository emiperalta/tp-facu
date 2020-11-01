<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h4 class="display-4 text-center" style="margin-top:20px; margin-bottom: 20px">Agregar alumno</h4>
        <div class="container" style="margin: 0 auto; width: 40%">
            <form method="post" action="AgregarAlumno">
                <div class="form-group">
                    <label>Nombre</label>
                    <input type="text" name="txtNombre" class="form-control" required="true">
                </div>
                <div class="form-group">
                    <label>Apellido</label>
                    <input type="text" name="txtApellido" class="form-control" required="true">
                </div>
                <div class="form-group">
                    <label>Edad</label>
                    <input type="number" min="1" name="txtEdad" class="form-control" required="true">
                </div>
                <div class="form-group">
                    <label>DNI</label>
                    <input type="text" name="txtDni" class="form-control" required="true">
                </div>
                <button type="submit" class="btn btn-primary">Agregar alumno</button>
            </form>
        </div>
    </body>
</html>
