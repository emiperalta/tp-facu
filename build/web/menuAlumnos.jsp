<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu alumnos</title>
    </head>
    <body>
        <p class="display-4 title">Menu Alumnos</p>
        <div class="container text-center" style="margin: 0 auto; width: 40%">
            <div class="list-group">
                <c:forEach items="${listaAlumnos}" var="alumno">
                    <p>
                        <a href="<%= request.getContextPath()%>/EditarAlumno?id=${alumno.idAlumno}" class="list-group-item list-group-item-action">
                            ID: ${alumno.idAlumno} - ${alumno.apellido}, ${alumno.nombre} - DNI: ${alumno.dni}
                        </a>
                        <a href="<%= request.getContextPath()%>/EliminarAlumno?id=${alumno.idAlumno}" class="list-group-item list-group-item-action">
                            <span class="text-danger">Eliminar</span>
                        </a>
                    </p>

                </c:forEach>
            </div>  
        </div>
        <br />
        <div class="container" style="margin: 0 auto; width: 40%">
            <a href="<%= request.getContextPath()%>/Alumno/AgregarAlumno" class="btn btn-primary">Agregar</a>
        </div>
    </body>
</html>
