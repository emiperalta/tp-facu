<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="public/images/bandera-arg.png"/>
        <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:ital,wght@0,200;0,300;0,400;0,600;0,700;0,900;1,200;1,300;1,400;1,600;1,700;1,900&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="public/stylesheet/estilos.css" />
        <title>AcademiARG</title>
    </head>
    <body>
            <c:set var="nologeado" scope="session" value="
                <nav class='navbar navbar-dark bg-dark'>
                    <a class='navbar-brand' href='/tp-facu/Principal'>AcademiARG</a>
                    <form class='form-inline my-2 my-lg-0'>
                        <a class='nav-link btn border mr-sm-2' style='color:white;' href='/tp-facu/Login'>LOGIN</a>
                    </form>
                </nav>" 
            /> 
                        
            <c:set var="logeado" scope="session" value ="
                <nav class='navbar navbar-expand-lg navbar-dark bg-dark'>
                    <a class='navbar-brand' href='/tp-facu/Principal'>AcademiARG</a> 
                    <button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarNav' aria-controls='navbarNav' aria-expanded='false' aria-label='Toggle navigation'>
                        <span class='navbar-toggler-icon'></span>
                    </button>
                    <div class='collapse navbar-collapse' id='navbarNav'>
                        <ul class='navbar-nav mr-auto mt-2 mt-lg-0'>
                            <li class='nav-item'>
                                <a class='nav-link' href='/tp-facu/AgregarPrograma'>Cargar programa</a>
                            </li>
                            <li class='nav-item'>
                                <a class='nav-link' href='/tp-facu/Curso'>Cursos</a>
                            </li>
                            <li class='nav-item'>
                                <a class='nav-link' href='/tp-facu/Alumno'>Alumnos</a>
                            </li>
                            <li class='nav-item'>
                                <a class='nav-link' href='/tp-facu/Inscripcion'>Inscripciones</a>
                            </li>
                            <li class='nav-item' style='margin-right:20px;'>
                                <a class='nav-link' href='/tp-facu/Reporte'>Reportes</a>
                            </li>
                        </ul>
                        <form class='form-inline my-2 my-lg-0'>
                            <a class='nav-link btn border mr-sm-2' style='color:white;' href='/tp-facu/Logout'>LOGOUT</a>
                        </form>
                    </div>
                </nav>" 
            />             
            
            <c:out value="${usuario == 'admin' ? logeado : nologeado}" escapeXml="false"/>
        
    </body>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</html>
