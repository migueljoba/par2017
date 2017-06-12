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
import py.una.pol.par.entities.Producto;
import py.una.pol.par.model.ProductoManager;

public class ProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        
        String requestPath = req.getServletPath();
        
        ProductoManager pm = new ProductoManager();
        String templateName = null;
        
        if (false) {
            List<Producto> productoLista = pm.getAll();
            req.setAttribute("productoLista", productoLista);
            templateName = "/ProductoLista.jsp";
        }

        RequestDispatcher rd = req.getRequestDispatcher(templateName);
        rd.forward(req, response);

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
    }
    


}
