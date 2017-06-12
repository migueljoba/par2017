<%@page contentType="text/html" pageEncoding="UTF-8" language="java"
        import="java.util.ArrayList,
        py.una.pol.par.entities.Producto" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar datos del producto</h1>
            <%
                Producto producto = (Producto) request.getAttribute("producto");
            %>

        <form method="POST">
            <input type="hidden" name="id_producto" value="<%=producto.getProductoId()%>">
            <input type="text" name="descripcion" placeholder="Descripción" value="<%=producto.getDescripcion()%>" required autofocus>
            <input type="number" name="id_categoria" placeholder="Cód. Categoría" value="<%=producto.getCategoriaId()%>" required>
            <input type="number" name="precio_unitario" placeholder="Precio" value="<%=producto.getPrecioUnitario()%>" required>
            <input type="number" name="cantidad" placeholder="Cantidad" value="<%=producto.getCantidad()%>">
            <input type="url" name="link_imagen" placeholder="URL de imagen" value="<%=producto.getLinkImagen()%>">
            <image src="<%=producto.getLinkImagen()%>"/>
            <input type="submit" value="Editar">
        </form>
            <form method="POST" action="/paronline/admin/producto/eliminar">
                <input type="hidden" name="id_producto" value="<%=producto.getProductoId()%>">
                <input type="submit" value="Eliminar">
            </form>
    </body>
</html>