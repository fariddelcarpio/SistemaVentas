package dao;

import java.sql.*;
import java.util.*;
import model.EmpleadoSistema;
import config.Conexion;

public class EmpleadoSistemaDAO {

    public List<EmpleadoSistema> listar() {
        List<EmpleadoSistema> lista = new ArrayList<>();
        String sql = "SELECT * FROM EmpleadoSistema";
        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                EmpleadoSistema e = new EmpleadoSistema();
                e.setIdEmpleadoSistema(rs.getInt("idEmpleadoSistema"));
                e.setIdEmpleado(rs.getInt("idEmpleado"));
                e.setUsuario(rs.getString("usuario"));
                e.setPassword(rs.getString("password"));
                e.setIdPerfilUsuario(rs.getInt("idPerfilUsuario"));
                lista.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void registrar(EmpleadoSistema e) {
        String sql = "INSERT INTO EmpleadoSistema (idEmpleado, usuario, password, idPerfilUsuario) VALUES (?, ?, ?, ?)";
        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, e.getIdEmpleado());
            ps.setString(2, e.getUsuario());
            ps.setString(3, e.getPassword());
            ps.setInt(4, e.getIdPerfilUsuario());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public EmpleadoSistema buscar(int id) {
        EmpleadoSistema e = null;
        String sql = "SELECT * FROM EmpleadoSistema WHERE idEmpleadoSistema = ?";
        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    e = new EmpleadoSistema();
                    e.setIdEmpleadoSistema(rs.getInt("idEmpleadoSistema"));
                    e.setIdEmpleado(rs.getInt("idEmpleado"));
                    e.setUsuario(rs.getString("usuario"));
                    e.setPassword(rs.getString("password"));
                    e.setIdPerfilUsuario(rs.getInt("idPerfilUsuario"));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }

    public void actualizar(EmpleadoSistema e) {
        String sql = "UPDATE EmpleadoSistema SET idEmpleado=?, usuario=?, password=?, idPerfilUsuario=? WHERE idEmpleadoSistema=?";
        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, e.getIdEmpleado());
            ps.setString(2, e.getUsuario());
            ps.setString(3, e.getPassword());
            ps.setInt(4, e.getIdPerfilUsuario());
            ps.setInt(5, e.getIdEmpleadoSistema());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM EmpleadoSistema WHERE idEmpleadoSistema=?";
        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
