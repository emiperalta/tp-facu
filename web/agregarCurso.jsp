<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar curso</title>
    </head>
    <body>
        <h4 class="display-4 text-center" style="margin-top:20px; margin-bottom: 20px">Agregar Curso</h4>
        <div class="container" style="margin: 0 auto; width: 40%">
            <form method="post" action="AgregarCurso">
                <div class="form-group">
                    <label>Tema</label>
                    <input type="text" name="txtTema" class="form-control" required="true">
                </div>
                <div class="form-group">
                    <label>Descripción</label>
                    <textarea type="text" name="txtDescripcion" style="resize:none;" rows="4" class="form-control" required="true"></textarea>
                </div>
                <div class="form-group">
                    <label>Costo</label>
                    <input type="number" min="1" name="txtCosto" class="form-control" required="true">
                </div>
                <button type="submit" class="btn btn-primary">Agregar curso</button>
            </form>
        </div>
    </body>
</html>
