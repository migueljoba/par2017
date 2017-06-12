package py.una.pol.par.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import py.una.pol.par.entities.Categoria;
import py.una.pol.par.entities.Producto;
import py.una.pol.par.util.DBUtils;

public class ProductoManager {

    /*	id_producto SERIAL PRIMARY KEY,
	descripcion VARCHAR(100),
	id_categoria INTEGER,
	precio_unitario INTEGER,
	cantidad INTEGER,
	link_image TEXT,
     */
    private String BASE_SQL = "SELECT p.*, c.descripcion categoria_descripcion "
            + "FROM producto p INNER JOIN categoria c "
            + "ON p.id_categoria = c.id_categoria ";

    private String INSERT_SQL = "INSERT INTO producto(descripcion, id_categoria,"
            + "precio_unitario, cantidad, link_image) "
            + "VALUES(?, ?, ?, ?, ?)";

    private String DELETE_SQL = "DELETE FROM categoria WHERE id_categoria = ?";

    private String UPDATE_SQL = "UPDATE producto SET descripcion = ?, "
            + "id_categoria = ?, precio_unitario = ?, cantidad = ?, "
            + "link_image = ? WHERE id_producto = ?";

    public boolean editar(Producto prod) {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement query = null;

        try {
            conn = DBUtils.getConnection();
            query = conn.prepareStatement(UPDATE_SQL);
            query.setString(1, prod.getDescripcion());
            query.setInt(2, prod.getCategoriaId());
            query.setInt(3, prod.getPrecioUnitario());
            query.setInt(4, prod.getCantidad());
            query.setString(5, prod.getLinkImagen());
            query.setInt(6, prod.getProductoId());

            query.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(ProductoManager.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            DBUtils.closeConnection(conn);
        }

        return retValue;
    }

    public Producto getById(Integer id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Producto prod = new Producto();

        // categoria asociada al producto
        Categoria cat = new Categoria();

        String quertString = BASE_SQL + " WHERE p.id_producto = ?";

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(quertString);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                prod.setProductoId(rs.getInt("id_producto"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setCategoriaId(rs.getInt("id_categoria"));
                prod.setCategoria(cat);
                prod.setPrecioUnitario(rs.getInt("precio_unitario"));
                prod.setCantidad(rs.getInt("cantidad"));
                prod.setLinkImagen(rs.getString("link_image"));

                cat.setCategoriaId(rs.getInt("id_categoria"));
                cat.setDescripcion(rs.getString("categoria_descripcion"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            DBUtils.closeConnection(conn);
        }

        return prod;
    }

    public boolean insertar(Producto prod) {

        boolean retValue = true;

        Connection conn = null;
        PreparedStatement query = null;

        try {
            conn = DBUtils.getConnection();
            query = conn.prepareStatement(INSERT_SQL);
            query.setString(1, prod.getDescripcion());
            query.setInt(2, prod.getCategoria().getCategoriaId());
            query.setInt(3, prod.getPrecioUnitario());
            query.setInt(4, prod.getCantidad());
            query.setString(5, prod.getLinkImagen());

            query.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(ProductoManager.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            DBUtils.closeConnection(conn);
        }

        return retValue;
    }

    public List<Producto> getAll() {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Producto> listaProducto = new ArrayList<Producto>();
        String queryString = BASE_SQL + " ORDER BY descripcion ASC";
        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(queryString);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Producto prod = new Producto();
                Categoria cat = new Categoria();

                prod.setProductoId(rs.getInt("id_producto"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setCategoriaId(rs.getInt("id_categoria"));
                prod.setCategoria(cat);
                prod.setPrecioUnitario(rs.getInt("precio_unitario"));
                prod.setCantidad(rs.getInt("cantidad"));
                prod.setLinkImagen(rs.getString("link_image"));
                cat.setCategoriaId(rs.getInt("id_categoria"));
                cat.setDescripcion(rs.getString("categoria_descripcion"));

                listaProducto.add(prod);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoManager.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            DBUtils.closeConnection(conn);
        }

        return listaProducto;
    }
}


