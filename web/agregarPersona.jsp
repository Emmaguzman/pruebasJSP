<%-- 
    Document   : PersonasForm
    Created on : 12-oct-2019, 20:16:09
    Author     : denis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AgregarPersona</title>
    </head>
    <body>
        <form method="get" action="PersonasControl">
            <input type="hidden" name="Comando" value="AGREGAR"/>

            <div class="col-md-3">
                <input type="text" name="txtNombre" class="form-control" placeholder="Nombre">
            </div>

            <div class="col-md-3">
                <input type="text" name="txtApellido"class="form-control" placeholder="Apellido">
            </div>
            <input class="btn btn-primary" type="submit" value="Guardar">
        </form>

    </body>
</html>
