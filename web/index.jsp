<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <title>Inicio</title>
    </head>
    <body>
        <div class="container mt-3 mb-4">
            <p class="display-3 text-center principal">
                AcademiARG <img src="public/images/bandera-arg.png" class="arg-icon"></img>
            </p>
        </div>        

        <div class="container mt-3 mb-5">
            <p class="lead bg-dark" style="padding: 20px; color: #fff;">
                Academia especializada en la enseñanza de programación. 
                Contamos con cursos de diferentes lenguajes y tecnologías, 
                y aquí en la nuestra página ofrecemos un link de descarga 
                de los proyectos finales de nuestros alumnos. <br /> <br />

                <span class="subtitle">¡A programar!</span>
            </p>
        </div>

        <hr />

        <div class="container mt-3 mb-5">
            <p class="display-4 text-center">
                Lista de proyectos finales de nuestros alumnos
            </p>
        </div>

        <div class="container mt-3">
            <div class="table-responsive">
                <table class="table table-hover table-bordered border" style="width:100%">
                    <c:if test="${usuario != 'admin' || usuario == '' || usuario == null}" >
                        <thead>
                            <tr class="text-center">
                                <th>Alumno</th>
                                <th>Programa</th>
                                <th>Tema</th>
                                <th>Descripción</th>
                                <th>Cantd. de descargas</th>
                                <th>ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listaProyectos}" var="pf" >
                                <c:if test="${pf.disponible}">
                                    <tr>

                                        <td class="text-center">${pf.nombreAlumno}</td>
                                        <td class="text-center">${pf.nombrePrograma}</td>
                                        <td class="text-center">${pf.temaPrograma}</td>
                                        <td>${pf.descripcion}</td>
                                        <td class="text-center">${pf.descargas}</td>
                                        <td class="text-center">
                                            <a href="<%= request.getContextPath()%>/DescargarPrograma?fileName=${pf.filename}">Descargar</a>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                    </c:if>
                    <c:if test="${usuario == 'admin'}">
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
                            <c:forEach items="${listaProyectos}" var="pf" >
                                <tr>
                                    <td class="text-center">${pf.nombreAlumno}</td>
                                    <td class="text-center">${pf.nombrePrograma}</td>
                                    <td class="text-center">${pf.temaPrograma}</td>
                                    <td>${pf.descripcion}</td>
                                    <td class="text-center">${pf.descargas}</td>
                                    <td class="text-center"><c:out value="${pf.disponible ? 'Si' : 'No'}" /></td>
                                    <td class="text-center">
                                        <c:set var = "str" scope = "session" value="<a href='/tp-facu/DescargarPrograma?id=${pf.idProgramaFinal}&fileName=${pf.filename}'>Descargar</a>"/> 
                                        <c:out value="${pf.disponible ? str : ''}" escapeXml="false"/>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </tbody>
                </table>
            </div> 
        </div>
    </body>
</html>
