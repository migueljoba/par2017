<%-- 
    Document   : Categoria
    Created on : 21/10/2014, 07:55:38 PM
    Author     : Mauricio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.ArrayList, onlineshop.ec.Categoria"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorias</title>
    </head>
    <body>
        <h1>Lista de Categorias</h1>
        <table>
            <tr>
                <th>Id</th>
                <th>Descripcion</th>
            </tr>

            <%
                ArrayList<Categoria> categorias = (ArrayList<Categoria>) request.getAttribute("categorias");
                for (Categoria c : categorias) {
            %>
            <tr>
                <td><%=c.getIdCategoria()%></td>
                <td><%=c.getDescripcion()%></td>
                <td>
                    <form action="/onlineshop/CategoriaServlet">
                        <input type="hidden" name="vaccion" value="Editar"/>
                        <input type="hidden" name="vid" value="<%=c.getIdCategoria()%>"/>
                        <input type="submit" value="Editar"/>
                    </form>
                </td>

                <td>
                    <form action="/onlineshop/CategoriaServlet">
                        <input type="hidden" name="vaccion" value="Eliminar"/>
                        <input type="hidden" name="vid" value="<%=c.getIdCategoria()%>"/>
                        <input type="submit" value="Eliminar"/>
                    </form>
                </td>
            </tr>
            <%
                }
            %>

        </table>
        <form action="/onlineshop/CategoriaNew.jsp">
            <input type="submit" value="Crear"/>
        </form>
    </body>
</html>
