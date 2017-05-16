package py.una.pol.par.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import py.una.pol.par.util.DBUtils;
import py.una.pol.par.entities.Usuario;

public class UsuarioManager {

    public boolean insertar(Usuario usuario) {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement("insert into usuario (nombre, apellido, rol, correo) "
                    + "values (?, ?, ?, ?)");
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getApellido());
            pstmt.setInt(3, usuario.getRol());
            pstmt.setString(4, usuario.getCorreo());
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            DBUtils.closeConnection(conn);
        }

        return retValue;
    }

    public boolean update(Usuario usuario) {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;

        String sqlString = "UPDATE usuario SET nombre = ?, apellido = ?, role = ?, correo = ? WHERE id_usuario = ? ";

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(sqlString);
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getApellido());
            pstmt.setInt(3, usuario.getRol());
            pstmt.setString(4, usuario.getCorreo());
            pstmt.setInt(5, usuario.getUsuarioId());
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtils.closeConnection(conn);
        }

        return retValue;
    }

    public boolean delete(Usuario usuario) {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;

        String sqlString = "DELEETE FROM usuario WHERE id_usuario = ?";

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(sqlString);
            pstmt.setInt(1, usuario.getUsuarioId());
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtils.closeConnection(conn);
        }

        return retValue;
    }

    public Usuario getById(int id) {
        Usuario retValue = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sqlString = "SELECT * FROM usuario WHERE usuario_id = ?";

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(sqlString);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                retValue = new Usuario();
                retValue.setNombre(rs.getString("nombre"));
                retValue.setApellido(rs.getString("apellido"));
                retValue.setUsuarioId(rs.getInt("id_usuario"));
                retValue.setCorreo(rs.getString("correo"));
                retValue.setRol(rs.getInt("rol"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtils.closeConnection(conn);
        }

        return retValue;
    }

    public ArrayList<Usuario> getAll() {
        ArrayList<Usuario> retValue = new ArrayList<Usuario>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sqlString = "SELECT * FROM usuario";
        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(sqlString);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setUsuarioId(rs.getInt("id_usuario"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setRol(rs.getInt("rol"));

                retValue.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtils.closeConnection(conn);
        }

        return retValue;
    }
}
