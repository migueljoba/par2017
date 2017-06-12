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
        <h1>Administración de Productos</h1>
        
        <a href="/paronline/admin/producto/agregar">Cargar Producto</a>
        
        <table>
            <tr>
                <th>Id</th>
                <th>Descripcion</th>
                <th>Cód. Categoría</th>
                <th>Precio Unitario</th>
                <th>Cantidad</th>
                <th>Acciones</th>
            </tr>

            <%
                ArrayList<Producto> productos = (ArrayList<Producto>) request.getAttribute("productoLista");
                for (Producto prod : productos) {
            %>
            <tr>
                <td><%=prod.getProductoId()%></td>
                <td><%=prod.getDescripcion()%></td>
                <td><%=prod.getCategoriaId()%></td>
                <td><%=prod.getPrecioUnitario()%></td>
                <td><%=prod.getCantidad()%></td>
                <td>
                    <a href="/paronline/admin/producto/editar?id=<%=prod.getProductoId()%>">Ver</a>
                </td>
                <td>

                </td>
            </tr>
            <%
                }
            %>

        </table>



    </body>
</html>
