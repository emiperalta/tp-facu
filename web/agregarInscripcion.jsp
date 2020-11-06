<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Inscripcion</title>
    </head>
    <body>
        <h4 class="display-4 text-center" style="margin-top:20px; margin-bottom: 20px">Agregar inscripción</h4>
        <br />
        <div class="container" style="margin: 0 auto; width: 40%">
            <form method="post" action="AgregarInscripcion">
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
                            <option value="${lc.idCurso}">${lc.tema} - $${lc.costo}</option>
                        </c:forEach>
                    </select>
                </div>                
                <div class="form-group">
                    <label>Descuento</label>
                    <select class="form-control" name="cmbDescuento">
                        <c:forEach items="${listaDescuentos}" var="ld">
                            <option value="${ld.idDescuento}">% ${ld.porcentaje}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Fecha de inicio</label>
                    <input type="text" name="txtFechaInicio" class="form-control" required="true">
                </div>
                <div class="form-group">
                    <label>Fecha de finalización</label>
                    <input type="text" name="txtFechaFin" class="form-control" required="true">
                </div>
                <button type="submit" class="btn btn-primary">Inscribir</button>
            </form>
        </div>
    </body>
</html>
