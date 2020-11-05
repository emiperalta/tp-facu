<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Curso</title>
    </head>
    <body>
        <h4 class="display-4 text-center" style="margin-top:20px; margin-bottom: 20px">Editar curso</h4>
        <div class="container" style="margin: 0 auto; width: 40%">
            <form method="post" action="EditarCurso">
                <input type="hidden" name="txtIdCurso" value="${cursoObtenido.idCurso}">
                <div class="form-group">
                    <label>Tema</label>
                    <input type="text" name="txtTema" value="${cursoObtenido.tema}" class="form-control" required="true">
                </div>
                <div class="form-group">
                    <label>Descripción</label>
                    <input type="text" name="txtDescripcion" value="${cursoObtenido.descripcion}" class="form-control" required="true">
                </div>
                <div class="form-group">
                    <label>Costo</label>
                    <input type="number" min="1" name="txtCosto" value="${cursoObtenido.costo}" class="form-control" required="true">
                </div>
                <button type="submit" class="btn btn-primary">Aceptar cambios</button>
            </form>
        </div>
    </body>
</html>
