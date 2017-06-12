<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello UsuarioForm!</h1>
        <form method="POST">
            <input type="text" name="nombre" placeholder="Nombre">
            <input type="text" name="apellido" placeholder="Apellido">
            <input type="text" name="rol" placeholder="Rol">
            <input type="text" name="correo" placeholder="Correo electrónico">
            <input type="submit" value="Guardar Usuario">
        </form>
    </body>
</html>
