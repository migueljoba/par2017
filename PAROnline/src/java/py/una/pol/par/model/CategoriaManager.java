package py.una.pol.par.model;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import py.una.pol.par.entities.Categoria;
import py.una.pol.par.util.DBUtils;

public class CategoriaManager {

    private String INSERT_SQL = "INSERT INTO categoria(descripcion) VALUES(?)";
    private String DELETE_SQL = "DELETE FROM categoria WHERE id_categoria = ?";
    private String BASE_SQL = "SELECT * FROM categoria ";
    private String UPDATE_SQL = "UPDATE categoria SET id_categoria = ?, "
            + "descripcion = ? WHERE id_categoria = ?";
    
    public boolean editar(Categoria categoria) {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;

        Integer categoriaId = categoria.getCategoriaId();
        String descripcion = categoria.getDescripcion();

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(UPDATE_SQL);
            pstmt.setInt(1, categoriaId);
            pstmt.setString(2, descripcion);
            pstmt.setInt(3, categoriaId);
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            DBUtils.closeConnection(conn);
        }

        return retValue;
    }
    
    public boolean eliminar(Categoria categoria) {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;

        Integer categoriaId = categoria.getCategoriaId();

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(DELETE_SQL);
            pstmt.setInt(1, categoriaId);
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            DBUtils.closeConnection(conn);
        }

        return retValue;
    }

    public boolean insertar(Categoria categoria) {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(INSERT_SQL);
            pstmt.setString(1, categoria.getDescripcion());

            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            DBUtils.closeConnection(conn);
        }

        return retValue;
    }

    public Categoria getById(Integer id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Categoria cat = new Categoria();

        String quertString = BASE_SQL + " WHERE id_categoria = ?";

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(quertString);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                cat.setCategoriaId(rs.getInt("id_categoria"));
                cat.setDescripcion(rs.getString("descripcion"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            DBUtils.closeConnection(conn);
        }

        return cat;
    }

    public List<Categoria> getAll() {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Categoria> listaCategoria = new ArrayList<Categoria>();
        String queryString = BASE_SQL + " ORDER BY descripcion ASC";
        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(queryString);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setCategoriaId(rs.getInt("id_categoria"));
                cat.setDescripcion(rs.getString("descripcion"));

                listaCategoria.add(cat);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            DBUtils.closeConnection(conn);
        }

        return listaCategoria;
    }

}
