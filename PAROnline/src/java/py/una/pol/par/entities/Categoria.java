/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.entities;

import javax.servlet.http.HttpServletRequest;

public class Categoria {

    private Integer categoriaId;
    private String descripcion;

    public Categoria() {
    }

    public Categoria(HttpServletRequest req) {
        String categoriaIdStr = req.getParameter("id_categoria");
        if (categoriaIdStr != null) {
            this.categoriaId = Integer.parseInt(categoriaIdStr);
        }

        this.descripcion = req.getParameter("descripcion");
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
