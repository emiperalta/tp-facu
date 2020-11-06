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
                                <td class="text-center">${rf.totalFacturado}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div> 
        </div>
    </body>
</html>
