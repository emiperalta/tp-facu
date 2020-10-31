<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Tema 3</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="<%= request.getContextPath()%>/Principal">Tema 3</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            <c:set var="nologeado" scope="session" value="
                <div class='collapse navbar-collapse' id='navbarNav'>
                    <ul class='navbar-nav'>
                        <li class='nav-item'>
                            <a class='nav-link' href='/TrabajoPracticoTema3/Login'>Login</a>
                        </li>
                    </ul>
                </div>'" 
            /> 
                        
            <c:set var="logeado" scope="session" value ="
                <div class='collapse navbar-collapse' id='navbarNav'>
                    <ul class='navbar-nav'>
                        <li class='nav-item'>
                            <a class='nav-link' href='/TrabajoPracticoTema3/Programas'>Cargar programa</a>
                        </li>
                        <li class='nav-item'>
                            <a class='nav-link' href='/TrabajoPracticoTema3/Cursos'>Cursos</a>
                        </li>
                        <li class='nav-item'>
                            <a class='nav-link' href='/TrabajoPracticoTema3/Alumnos'>Alumnos</a>
                        </li>
                        <li class='nav-item'>
                            <a class='nav-link' href='/TrabajoPracticoTema3/Inscripciones'>Inscripciones</a>
                        </li>
                    </ul>
                </div>" 
            />             
            
            <c:out value="${usuario == 'admin' ? logeado : nologeado}" escapeXml="false"/>
        </nav>
    </body>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</html>
