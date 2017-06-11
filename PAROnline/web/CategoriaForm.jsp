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
        <h1>Hello CategoriaForm!</h1>
        <form method="POST">
            <input type="hidden" name="accion" value="agregar">
            <input type="text" name="descripcion" placeholder="Descripción" required autofocus>
            <input type="submit" value="Guardar">
        </form>


        <h1>Lista de Categorias</h1>
        <table>
            <tr>
                <th>Id</th>
                <th>Descripcion</th>
                <th colspan="2">Acciones</th>
            </tr>

            <%
                ArrayList<Categoria> categorias = (ArrayList<Categoria>) request.getAttribute("categoriaLista");
                for (Categoria c : categorias) {
            %>
            <tr>
                <td><%=c.getCategoriaId()%></td>
                <td><%=c.getDescripcion()%></td>
                <td>
                    <a href="/paronline/categoria?id=<%=c.getCategoriaId()%>">Editar</a>
                </td>
                <td>
                    <form method="POST">
                        <input type="hidden" name="accion" value="eliminar">
                        <input type="hidden" name="id_categoria" value="<%=c.getCategoriaId()%>">
                        <input type="submit" value="Eliminar">
                    </form>


                </td>
            </tr>
            <%
                }
            %>

        </table>



    </body>
</html>
