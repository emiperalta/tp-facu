<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Cursos</title>
    </head>
    <body>
        <p class="display-4 title">Menu Alumnos</p>
        <div class="container text-center alumnos-container" >
            
            <div class="container" style="margin: 20px auto">
                <a href="<%= request.getContextPath()%>/AgregarAlumno" class="btn btn-info">Agregar</a>
            </div>
            
            <div class="list-group">
                <c:forEach items="${listaCursos}" var="curso">
                    <p>
                        <a href="<%= request.getContextPath()%>/EditarCurso?id=${curso.idCurso}" class="list-group-item list-group-item-action">
                            ID: ${curso.idCurso} - ${curso.tema}, ${curso.descripcion} - Costo: $${curso.costo}
                        </a>
                        <a href="<%= request.getContextPath()%>/EliminarCurso?id=${curso.idCurso}" class="list-group-item list-group-item-action">
                            <span class="text-danger">Eliminar</span>
                        </a>
                    </p>
                </c:forEach>
            </div>  
        </div>
    </body>
</html>
