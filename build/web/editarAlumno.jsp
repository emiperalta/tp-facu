<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Alumno</title>
    </head>
    <body>
        <h4 class="display-4 text-center" style="margin-top:20px; margin-bottom: 20px">Editar alumno</h4>
        <div class="container" style="margin: 0 auto; width: 40%">
            <form method="post" action="EditarAlumno">
                <input type="hidden" name="txtIdAlumno" value="${alumnoObtenido.idAlumno}">
                <div class="form-group">
                    <label>Nombre</label>
                    <input type="text" name="txtNombre" value="${alumnoObtenido.nombre}" class="form-control" required="true">
                </div>
                <div class="form-group">
                    <label>Apellido</label>
                    <input type="text" name="txtApellido" value="${alumnoObtenido.apellido}" class="form-control" required="true">
                </div>
                <div class="form-group">
                    <label>Edad</label>
                    <input type="number" min="1" name="txtEdad" value="${alumnoObtenido.edad}" class="form-control" required="true">
                </div>
                <div class="form-group">
                    <label>DNI</label>
                    <input type="text" name="txtDni" value="${alumnoObtenido.dni}" class="form-control" required="true">
                </div>
                <button type="submit" class="btn btn-primary">Aceptar cambios</button>
            </form>
        </div>
    </body>
</html>
