<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Reportes</title>
    </head>
    <body>
        <div class="container mt-3">            
            <br />
            <div>
                <p class="display-4 text-center">
                    Listado de alumnos por curso seleccionado
                </p>
            </div>
            <br />
            <form method="get" action="Reporte">
                <div class="form-group">
                    <label>Seleccione curso</label>
                    <select class="form-control" name="cmbCurso">
                        <c:forEach items="${listaCursos}" var="lc">
                            <option value="${lc.idCurso}">${lc.tema}</option>
                        </c:forEach>
                    </select>
                </div>
                <p>
                    <input type="submit" class="btn btn-sm btn-info" value="Consultar">
                </p>                        
            </form>
            <c:if test="${!listaVacia && listaAlumnosxCurso.size() > 0}">
                <div class="table-responsive">
                    <table class="table table-hover table-sm table-bordered border" style="width:100%">
                        <thead>
                            <tr class="text-center">
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Edad</th>
                                <th>DNI</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listaAlumnosxCurso}" var="lac" >
                                <tr>
                                    <td class="text-center">${lac.idAlumno}</td>
                                    <td class="text-center">${lac.nombre}</td>
                                    <td class="text-center">${lac.apellido}</td>
                                    <td class="text-center">${lac.edad}</td>
                                    <td class="text-center">${lac.dni}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div> 
            </c:if>
            <c:if test="${listaVacia}">
                <h3 class="text-center">
                    ¡Ningún curso seleccionado!
                </h3>
            </c:if>
        </div>
        <br />
        <div class="container mt-3">            
            <br />
            <div>
                <p class="display-4 text-center">
                    Total facturado por cada curso
                </p>
            </div>
            <br />
            <div class="table-responsive">
                <table class="table table-hover table-sm table-bordered border" style="width:100%">
                    <thead>
                        <tr class="text-center">
                            <th>ID Curso</th>
                            <th>Tema</th>
                            <th>Monto total facturado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaMontoCurso}" var="rf" >
                            <tr>
                                <td class="text-center">${rf.idCurso}</td>
                                <td class="text-center">${rf.tema}</td>
                                <td class="text-center">$${rf.totalFacturado}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div> 
        </div>
        <br />
        <div class="container mt-3">            
            <br />
            <div>
                <p class="display-4 text-center">
                    Sumatoria total de los descuentos realizados
                </p>
            </div>
            <br />
            <div class="container text-center" style="font-size:30px; font-style: italic">
                ${sumatoriaDescuentos}
            </div> 
        </div>
        <br />
        <div class="container mt-3">            
            <br />
            <div>
                <p class="display-4 text-center">
                    Listado de los 5 programas más descargados
                </p>
            </div>
            <br />
            <div class="table-responsive">
                <table class="table table-hover table-sm table-bordered border" style="width:100%">
                    <thead>
                        <tr class="text-center">
                            <th>Nombre del programa</th>
                            <th>Descargas</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaProgramasMasDesc}" var="lpmd" >
                            <tr>
                                <td class="text-center">${lpmd.nombrePrograma}</td>
                                <td class="text-center">${lpmd.cantidadDescargas}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div> 
        </div>
        <br />
        <div class="container mt-3">            
            <br />
            <div>
                <p class="display-4 text-center">
                    Listado de alumnos que accedieron a algún descuento
                </p>
            </div>
            <br />
            <div class="table-responsive">
                <table class="table table-hover table-sm table-bordered border" style="width:100%">
                    <thead>
                        <tr class="text-center">
                            <th>ID</th>
                            <th>Nombre completo</th>
                            <th>DNI</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaAlumnosConDesc}" var="lad" >
                            <tr>
                                <td class="text-center">${lad.idAlumno}</td>
                                <td class="text-center">${lad.nombreCompleto}</td>
                                <td class="text-center">${lad.dni}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div> 
        </div>
        <br />
    </body>
</html>
