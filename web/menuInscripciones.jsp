<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Inscripciones</title>
    </head>
    <body>
        <p class="display-4 title">Menu Inscripciones</p>
        <div class="container text-center alumnos-container" >
            <div class="container" style="margin: 20px auto">
                <a href="<%= request.getContextPath()%>/AgregarInscripcion" class="btn btn-info">Inscribir ALUMNO</a>
            </div>
        </div>
        <div class="table-responsive">
            <table class="table table-bordered" style="width:100%">
                <thead>
                    <tr class="text-center">
                        <th>ID</th>
                        <th>Alumno</th>
                        <th>Curso</th>
                        <th>Descuento</th>
                        <th>Fecha de inicio</th>
                        <th>Fecha de finalización</th>
                        <th>Monto</th>
                        <th>Monto de descuento</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaInscripciones}" var="listaInsc" >
                        <tr>
                            <td class="text-center">${listaInsc.idInscripcion}</td>
                            <td class="text-center">${listaInsc.nombreAlumno}</td>
                            <td class="text-center">${listaInsc.temaCurso}</td>
                            <td class="text-center">%${listaInsc.porcentajeDescuento}</td>
                            <td class="text-center">${listaInsc.fechaInicio}</td>
                            <td class="text-center">${listaInsc.fechaFin}</td>
                            <td class="text-center">$${listaInsc.monto}</td>
                            <td class="text-center">$${listaInsc.montoDescuento}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
