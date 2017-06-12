package py.una.pol.par.entities;

import javax.servlet.http.HttpServletRequest;
import py.una.pol.par.entities.Categoria;

public class Producto {

    private Integer productoId;
    private String descripcion;
    private Integer categoriaId;
    private Categoria categoria;
    private Integer precioUnitario;
    private Integer cantidad;
    private String linkImagen;

    public Producto() {
    }

    public Producto(HttpServletRequest req) {
        String productoIdStr = req.getParameter("id_producto");
        if (productoIdStr != null) {
            this.productoId = Integer.parseInt(productoIdStr);
        }
        
        this.descripcion = req.getParameter("descripcion");

        String categoriaIdStr = req.getParameter("id_categoria");
        if (categoriaIdStr != null) {
            this.categoriaId = Integer.parseInt(categoriaIdStr);
        }

        String precioUnintarioStr = req.getParameter("precio_unitario");
        if (precioUnintarioStr != null) {
            this.precioUnitario = Integer.parseInt(precioUnintarioStr);
        }

        String cantidadStr = req.getParameter("cantidad");
        if (cantidadStr != null) {
            this.cantidad = Integer.parseInt(cantidadStr);
        }

        this.linkImagen = req.getParameter("link_imagen");

    }

    public Producto(Integer productoId, String descripcion, Categoria categoria,
            Integer precioUnitario, Integer cantidad, String linkImagen) {

        this.productoId = productoId;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.linkImagen = linkImagen;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Integer precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getLinkImagen() {
        return linkImagen;
    }

    public void setLinkImagen(String linkImagen) {
        this.linkImagen = linkImagen;
    }
}
