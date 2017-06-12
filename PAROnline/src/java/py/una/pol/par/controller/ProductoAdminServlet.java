/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import py.una.pol.par.entities.Categoria;
import py.una.pol.par.entities.Producto;
import py.una.pol.par.model.CategoriaManager;
import py.una.pol.par.model.ProductoManager;

/**
 *
 * @author mjose
 */
public class ProductoAdminServlet extends HttpServlet {

    private String URL_BASE = "/paronline/admin/producto";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String requestPath = request.getServletPath();
        String templateName = null;

        switch (requestPath) {

            case "/admin/producto":
                principal(request, response);
                return;

            case "/admin/producto/agregar":
                agregarGet(request, response);
                return;

            case "/admin/producto/editar":
                editarGet(request, response);
                return;

            case "/admin/producto/eliminar":
                templateName = "/producto/ProductoEliminar.jsp";
                break;
        }

        RequestDispatcher rd = request.getRequestDispatcher(templateName);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestPath = request.getServletPath();
        String templateName = null;

        switch (requestPath) {
            case "/admin/producto/agregar":
                agregarPost(request, response);
                return;

            case "/admin/producto/editar":
                editarPost(request, response);
                return;

            case "/admin/producto/eliminar":
                templateName = "/producto/ProductoEliminar.jsp";
                break;
        }

        RequestDispatcher rd = request.getRequestDispatcher(templateName);
        rd.forward(request, response);
    }

    public void principal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ProductoManager pm = new ProductoManager();
        
        List<Producto> productoLista = pm.getAll();
        request.setAttribute("productoLista", productoLista);
        
        String templateName = templateName = "/producto/ProductoIndex.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(templateName);
        rd.forward(request, response);

    }

    public void agregarGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String templateName = "/producto/ProductoAgregar.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(templateName);
        rd.forward(request, response);
    }

    public boolean agregarPost(HttpServletRequest request, HttpServletResponse response) {
        Producto producto = new Producto(request);

        ProductoManager pm = new ProductoManager();
        CategoriaManager cm = new CategoriaManager();

        Categoria categoria = cm.getById(producto.getCategoriaId());
        producto.setCategoria(categoria);

        pm.insertar(producto);

        return true;
    }

    public void editarGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String productoIdStr = request.getParameter("id");

        ProductoManager pm = new ProductoManager();
        Producto producto = pm.getById(Integer.valueOf(productoIdStr));

        request.setAttribute("producto", producto);

        String templateName = "/producto/ProductoEditar.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(templateName);
        rd.forward(request, response);
    }

    public void editarPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String productoIdStr = request.getParameter("id");
        Producto producto = new Producto(request);

        ProductoManager pm = new ProductoManager();
        pm.editar(producto);

        String redirectTo = String.format("%s/editar?id=%s",
                URL_BASE, productoIdStr);

        response.sendRedirect(redirectTo);

    }
}
