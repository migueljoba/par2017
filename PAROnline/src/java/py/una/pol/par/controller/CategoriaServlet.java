package py.una.pol.par.controller;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import py.una.pol.par.entities.Categoria;
import py.una.pol.par.model.CategoriaManager;

public class CategoriaServlet extends HttpServlet {

    /*
        GET    => READ
        POST   => CREATE
        DELETE => DELETE
        PUT    => UPDATE
     */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CategoriaManager cm = new CategoriaManager();
        String templateName = null;

        /* Se solicita categoria según su id */
        String categoriaIdStr = request.getParameter("id");
        if (categoriaIdStr != null) {
            Integer parsedId = Integer.valueOf(categoriaIdStr);
            Categoria categoria = cm.getById(parsedId);
            request.setAttribute("categoria", categoria);

            templateName = "/CategoriaFormEdit.jsp";

        } else {
            List<Categoria> categoriaLista = cm.getAll();
            request.setAttribute("categoriaLista", categoriaLista);
            templateName = "/CategoriaForm.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(templateName);
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = req.getParameter("accion");

        if ("eliminar".equalsIgnoreCase(accion)) {
            doDelete(req, response);
        }

        if ("editar".equalsIgnoreCase(accion)) {
            doPut(req, response);
            return;
        }

        if ("agregar".equalsIgnoreCase(accion)) {
            Categoria categoria = new Categoria(req);
            CategoriaManager um = new CategoriaManager();
            um.insertar(categoria);
        }

        doGet(req, response);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {

        String categoriaIdStr = req.getParameter("id_categoria");

        Categoria categoria = new Categoria();
        categoria.setCategoriaId(Integer.valueOf(categoriaIdStr));

        CategoriaManager cm = new CategoriaManager();
        cm.eliminar(categoria);

        doGet(req, response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {

        Categoria categoria = new Categoria(req);

        CategoriaManager cm = new CategoriaManager();
        cm.editar(categoria);
        
        response.sendRedirect("/paronline/categoria");
    }

}
