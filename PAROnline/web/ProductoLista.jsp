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
        <header>

            <a href="#">
                <h2>Mis Compras</h2>
            </a>

        </header>
        <section>
            <form action="">
                <input type="text" placeholder="Buscar producto">
                <input type="submit" value="Buscar">
            </form>

            <header><h3>Lista de productos</h3>
                <nav>
                    <ul>
                        <li class="python-meta ">
                            <a href="#">Iniciar Sesión</a>
                        </li>
                        <li class="python-meta ">
                            <a href="#">Otra opción</a>
                        </li>
                    </ul>
                </nav>
            </header>

            <div>

                <%
                    ArrayList<Producto> productos = (ArrayList<Producto>) request.getAttribute("productoLista");
                    for (Producto p : productos) {
                %>
                <div>
                    <div><h4><%=p.getDescripcion()%></h4></div>
                    <div>
                        <a href="detalle_producto.html">
                            <img src="images/producto_001.jpg" />
                        </a>
                    </div>

                    <div>Detalle del producto Lorem ipsum dolor sit amet, consectetur ...</div>
                </div>
                <%
                    }
                %>

            </div>

        </section>

        <footer>Mis Compras - Copyright 2017</footer>
    </body>
</html>

<footer>
    Some copyright info or perhaps some author
    info for an &lt;article&gt;?
</footer>

</body>
</body>
</html>
