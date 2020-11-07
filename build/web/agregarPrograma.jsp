<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Programa</title>
    </head>
    <body>
        <h4 class="display-4 text-center" style="margin-top:20px; margin-bottom: 20px">Agregar programa</h4>
        <br />
        <div class="container" style="margin: 0 auto; width: 40%">
            <form method="post" action="AgregarPrograma" enctype="multipart/form-data">
                <div class="form-group">
                    <label>Alumno</label>
                    <select class="form-control" name="cmbAlumno">
                        <c:forEach items="${listaAlumnos}" var="la">
                            <option value="${la.idAlumno}">${la.nombre} ${la.apellido}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Curso</label>
                    <select class="form-control" name="cmbCurso">
                        <c:forEach items="${listaCursos}" var="lc">
                            <option value="${lc.idCurso}">${lc.tema}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Nombre del programa</label>
                    <input type="text" name="txtNombrePrograma" class="form-control" required="true">
                </div>
                <div class="form-group">
                    <label>Descripción</label>
                    <textarea type="text" name="txtDescripcion" rows="4" style="resize:none;" class="form-control" required="true"></textarea>
                </div>
                <div class="form-group">
                    <label>Programa</label>
                    <input type="file" name="inputPrograma" class="form-control-file" required="true" />
                </div>
                <div class="form-group">
                    <label>¿Está disponible?</label>
                    <input type="checkbox" name="txtDisponible" class="check" value="txtDisponible" >
                </div>
                <button type="submit" class="btn btn-primary">Agregar programa</button>
            </form>
        </div>
    </body>
</html>
