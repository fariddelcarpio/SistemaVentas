package dao;

import config.Conexion;
import java.sql.*;
import java.util.*;
import model.MovimientosProducto;

public class MovimientosProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<MovimientosProducto> listar() {
        List<MovimientosProducto> lista = new ArrayList<>();
        String sql =
            "SELECT mp.idMovimientoProducto, " +
            "       mp.idTipoMovimiento, " +
            "       mp.idProducto, " +
            "       tm.detalle AS tipoMovimiento, " +
            "       p.nombre AS nombreProducto, " +
            "       mp.cantidad " +
            "FROM MovimientosProducto mp " +
            "JOIN TipoMovimiento tm ON mp.idTipoMovimiento = tm.idTipoMovimiento " +
            "JOIN Producto p ON mp.idProducto = p.idProducto " +
            "ORDER BY mp.idMovimientoProducto DESC";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MovimientosProducto mp = new MovimientosProducto();
                mp.setIdMovimientoProducto(rs.getInt("idMovimientoProducto"));
                mp.setIdTipoMovimiento(rs.getInt("idTipoMovimiento"));
                mp.setIdProducto(rs.getInt("idProducto"));
                mp.setTipoMovimientoNombre(rs.getString("tipoMovimiento"));
                mp.setNombreProducto(rs.getString("nombreProducto"));
                mp.setCantidad(rs.getInt("cantidad"));
                lista.add(mp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }


    public void agregar(MovimientosProducto mp) {
        String sql = "INSERT INTO MovimientosProducto (idTipoMovimiento, idProducto, cantidad) VALUES (?, ?, ?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, mp.getIdTipoMovimiento());
            ps.setInt(2, mp.getIdProducto());
            ps.setInt(3, mp.getCantidad());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en MovimientosProductoDAO.agregar: " + e.getMessage());
        }
    }
}
