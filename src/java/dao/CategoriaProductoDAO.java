package dao;

import config.Conexion;
import java.sql.*;
import java.util.*;
import model.CategoriaProducto;

public class CategoriaProductoDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public List<CategoriaProducto> listar() {
        List<CategoriaProducto> lista = new ArrayList<>();
        String sql = "SELECT * FROM CategoriaProducto";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CategoriaProducto c = new CategoriaProducto();
                c.setIdCategoriaProducto(rs.getInt("idCategoriaProducto"));
                c.setNombreCategoria(rs.getString("nombreCategoria"));
                lista.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error al listar categorías: " + e.getMessage());
        }
        return lista;
    }

    public void agregar(CategoriaProducto c) {
        String sql = "INSERT INTO CategoriaProducto(nombreCategoria) VALUES (?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombreCategoria());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al agregar categoría: " + e.getMessage());
        }
    }

    public CategoriaProducto obtenerPorId(int id) {
        CategoriaProducto c = new CategoriaProducto();
        String sql = "SELECT * FROM CategoriaProducto WHERE idCategoriaProducto = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                c.setIdCategoriaProducto(rs.getInt("idCategoriaProducto"));
                c.setNombreCategoria(rs.getString("nombreCategoria"));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener categoría: " + e.getMessage());
        }
        return c;
    }

    public void actualizar(CategoriaProducto c) {
        String sql = "UPDATE CategoriaProducto SET nombreCategoria = ? WHERE idCategoriaProducto = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombreCategoria());
            ps.setInt(2, c.getIdCategoriaProducto());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar categoría: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM CategoriaProducto WHERE idCategoriaProducto = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar categoría: " + e.getMessage());
        }
    }
}

