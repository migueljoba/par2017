<%@page contentType="text/html" pageEncoding="UTF-8" language="java"
        import="java.util.ArrayList,
        py.una.pol.par.entities.Categoria" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Categoria Edicion!</h1>
            <%
                Categoria categoria = (Categoria) request.getAttribute("categoria");
            %>

        <form method="POST">
            <input type="hidden" name="accion" value="editar">
            <input type="hidden" name="id_categoria" value="<%=categoria.getCategoriaId()%>">
            <input type="text" name="descripcion" placeholder="Descripción" value="<%=categoria.getDescripcion()%>" required autofocus>
            <input type="submit" value="Editar">
            <input type="submit" value="Eliminar">
        </form>
    </body>
</html>
