<%-- 
    Document   : listaPersona
    Created on : 13-oct-2019, 1:07:12
    Author     : denis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listaPersona2</title>
    </head>
    <body>
        <input type="button" value="AgregarPersona" onclick="window.location.href = 'agregarPersona.jsp'; return false;" >
        <table class="table table-dark">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach items="${List}" var ="p">
                    <c:url var="cargaLink" value="PersonasControl">
                        <c:param name="Comando" value="CARGA" />
                        <c:param name="idPersona" value="${p.id}" />
                    </c:url>
                    <c:url var="deleteLink" value="PersonasControl">
                        <c:param name="Comando" value="BORRAR" />
                        <c:param name="idPersona" value="${p.id}" />
                    </c:url>
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.nombre}</td>                        
                        <td>${p.apellido}</td>
                        <td>
                <a href="${cargaLink}">Actualizar</a>
                <a href="${deleteLink}" onclick="if (!(confirm('Esta seguro que quiere borrar a esta persona?')))return false">Borrar </a>
                        </td>
                    </tr>


                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
