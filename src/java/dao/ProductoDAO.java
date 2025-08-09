package dao;

import config.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Producto;

public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM Producto";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setIdCategoriaProducto(rs.getInt("idCategoriaProducto"));
                p.setCodigoBarras(rs.getString("codigoBarras"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecioUnitario(rs.getDouble("precioUnitario"));
                p.setUnidadMedida(rs.getString("unidadMedida"));
                p.setStock(rs.getInt("stock"));
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error al listar productos: " + e.getMessage());
        }
        return lista;
    }

    public boolean agregar(Producto p) {
        String sql = "INSERT INTO Producto (idCategoriaProducto, codigoBarras, nombre, precioUnitario, unidadMedida, stock) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getIdCategoriaProducto());
            ps.setString(2, p.getCodigoBarras());
            ps.setString(3, p.getNombre());
            ps.setDouble(4, p.getPrecioUnitario());
            ps.setString(5, p.getUnidadMedida());
            ps.setInt(6, p.getStock());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al agregar producto: " + e.getMessage());
            return false;
        }
    }

    public Producto obtenerPorId(int id) {
        Producto p = new Producto();
        String sql = "SELECT * FROM Producto WHERE idProducto = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                p.setIdProducto(rs.getInt("idProducto"));
                p.setIdCategoriaProducto(rs.getInt("idCategoriaProducto"));
                p.setCodigoBarras(rs.getString("codigoBarras"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecioUnitario(rs.getDouble("precioUnitario"));
                p.setUnidadMedida(rs.getString("unidadMedida"));
                p.setStock(rs.getInt("stock"));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener producto: " + e.getMessage());
        }
        return p;
    }

    public boolean actualizar(Producto p) {
        String sql = "UPDATE Producto SET idCategoriaProducto=?, codigoBarras=?, nombre=?, precioUnitario=?, unidadMedida=?, stock=? WHERE idProducto=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getIdCategoriaProducto());
            ps.setString(2, p.getCodigoBarras());
            ps.setString(3, p.getNombre());
            ps.setDouble(4, p.getPrecioUnitario());
            ps.setString(5, p.getUnidadMedida());
            ps.setInt(6, p.getStock());
            ps.setInt(7, p.getIdProducto());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Producto WHERE idProducto=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
            return false;
        }
    }
    
    public void actualizarStock(int idProducto, int nuevoStock) {
        String sql = "UPDATE Producto SET stock = ? WHERE idProducto = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, nuevoStock);
            ps.setInt(2, idProducto);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

