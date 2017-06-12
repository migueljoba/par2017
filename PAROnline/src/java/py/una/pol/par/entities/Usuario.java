/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.entities;

import javax.servlet.http.HttpServletRequest;

public class Usuario {

    private Integer usuarioId;
    private String nombre;
    private String apellido;
    private Integer rol;
    private String correo;

    public Usuario() {
    }

    public Usuario(HttpServletRequest req) {
        this.nombre = req.getParameter("nombre");
        this.apellido = req.getParameter("apellido");
        this.rol = Integer.parseInt(req.getParameter("rol"));
        this.correo = req.getParameter("correo");
    }
    
    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer uduarioId) {
        this.usuarioId = uduarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
