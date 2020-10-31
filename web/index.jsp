<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Inicio</title>
    </head>
    <body>
        <h4 class="display-4 text-center" style="margin-top:20px; margin-bottom: 20px">Academia</h4>
        <div class="container">
            <div class="table-responsive">
                <table class="table table-hover table-dark border" style="width:100%">
                    <thead>
                        <tr class="text-center">
                            <th>Alumno</th>
                            <th>Programa</th>
                            <th>Tema</th>
                            <th>Descripción</th>
                            <th>Cantd. de descargas</th>
                            <th>Disponible</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${lista}" var="pf" >
                            <tr>

                                <td class="text-center">${pf.nombreAlumno}</td>
                                <td class="text-center">${pf.nombrePrograma}</td>
                                <td class="text-center">${pf.temaPrograma}</td>
                                <td>${pf.descripcion}</td>
                                <td class="text-center">${pf.descargas}</td>
                                <td class="text-center"><c:out value="${pf.disponible ? 'Si' : 'No'}" /></td>
                                <td class="text-center">
                                    <c:set var = "str" scope = "session" value = "<a href='#'>Descargar</a>"/> 
                                    <c:out value="${pf.disponible ? str : ''}" escapeXml="false"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div> 
        </div>
    </body>
</html>
