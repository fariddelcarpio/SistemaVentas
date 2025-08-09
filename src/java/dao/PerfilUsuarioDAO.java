package dao;

import config.Conexion;
import java.sql.*;
import java.util.*;
import model.PerfilUsuario;

public class PerfilUsuarioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<PerfilUsuario> listar() {
        List<PerfilUsuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM PerfilUsuario";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PerfilUsuario p = new PerfilUsuario();
                p.setIdPerfilUsuario(rs.getInt("idPerfilUsuario"));
                p.setDescripcion(rs.getString("descripcion"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void agregar(PerfilUsuario perfil) {
        String sql = "INSERT INTO PerfilUsuario (descripcion) VALUES (?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, perfil.getDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM PerfilUsuario WHERE idPerfilUsuario = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
