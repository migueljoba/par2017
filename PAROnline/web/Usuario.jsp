<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.ArrayList, py.una.pol.par.entities.Usuario" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            Usuario usuario = (Usuario) request.getAttribute("usuario");
        %>
        <h3><%=usuario.getNombre()%></h3>
        <h3><%=usuario.getApellido()%></h3>
        <h3><%=usuario.getCorreo()%></h3>
    </body>
</html>
