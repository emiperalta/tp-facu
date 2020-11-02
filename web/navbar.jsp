<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:ital,wght@0,200;0,300;0,400;0,600;0,700;0,900;1,200;1,300;1,400;1,600;1,700;1,900&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="public/stylesheet/estilos.css" />
        <title>AcademiARG</title>
    </head>
    <body>
            <c:set var="nologeado" scope="session" value="
                <nav class='navbar navbar-dark bg-dark'>
                    <a class='navbar-brand' href='/TrabajoPracticoTema3/Principal'>AcademiARG</a>
                    <ul class='navbar-nav'>
                        <li class='nav-item'>
                            <a class='btn border' style='color:white;' href='/TrabajoPracticoTema3/Login'>LOGIN</a>
                        </li>
                    </ul>
                </nav>" 
            /> 
                        
            <c:set var="logeado" scope="session" value ="
                <nav class='navbar navbar-expand-lg navbar-dark bg-dark'>
                    <a class='navbar-brand' href='/TrabajoPracticoTema3/Principal'>AcademiARG</a> 
                    <button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarNav' aria-controls='navbarNav' aria-expanded='false' aria-label='Toggle navigation'>
                        <span class='navbar-toggler-icon'></span>
                    </button>
                    <div class='collapse navbar-collapse' id='navbarNav'>
                        <ul class='navbar-nav'>
                            <li class='nav-item'>
                                <a class='nav-link' href='/TrabajoPracticoTema3/Programa'>Cargar programa</a>
                            </li>
                            <li class='nav-item'>
                                <a class='nav-link' href='/TrabajoPracticoTema3/Curso'>Cursos</a>
                            </li>
                            <li class='nav-item'>
                                <a class='nav-link' href='/TrabajoPracticoTema3/Alumno'>Alumnos</a>
                            </li>
                            <li class='nav-item'>
                                <a class='nav-link' href='/TrabajoPracticoTema3/Inscripcion'>Inscripciones</a>
                            </li>
                            <li class='nav-item'>
                                <a class='nav-link btn border' href='/TrabajoPracticoTema3/Logout'>LOGOUT</a>
                            </li>
                        </ul>
                    </div>
                </nav>" 
            />             
            
            <c:out value="${usuario == 'admin' ? logeado : nologeado}" escapeXml="false"/>
        
    </body>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</html>
