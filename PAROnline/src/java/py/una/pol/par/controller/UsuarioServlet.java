/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import py.una.pol.par.entities.Usuario;
import py.una.pol.par.model.UsuarioManager;

/**
 *
 * @author mjose
 */
public class UsuarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuarioServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vaccion = request.getParameter("vaccion");
        request.setAttribute("vaccion", vaccion);

        /*
        Usuario usuario = new Usuario();
        usuario.setNombre("Nombre del Usu");
        usuario.setApellido("Apellido del usu");
        usuario.setCorreo("Correo del Usuario");
        request.setAttribute("usuario", usuario);
         */
        RequestDispatcher rd = request.getRequestDispatcher("/UsuarioForm.jsp");

        if (rd != null) {
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = new Usuario(req);

        UsuarioManager um = new UsuarioManager();

        um.insertar(usuario);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usuario = new Usuario();
        UsuarioManager um = new UsuarioManager();

        um.insertar(usuario);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
