<%-- 
    Document   : ProductoAgregar
    Created on : Jun 12, 2017, 12:14:38 AM
    Author     : mjose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Agregar Producto</h1>
        <form method="POST">
            <input type="text" name="descripcion" placeholder="Descripción" required autofocus>
            <input type="number" name="id_categoria" placeholder="Cód. Categoría" required>
            <input type="number" name="precio_unitario" placeholder="Precio unitario" required>
            <input type="number" name="cantidad" placeholder="Cantidad en stock" required>
            <input type="url" name="link_imagen" placeholder="Link de imagen" required>
            <input type="submit" value="Guardar">
        </form>
    </body>
</html>
