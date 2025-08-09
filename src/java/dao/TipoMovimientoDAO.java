package dao;

import config.Conexion;
import java.sql.*;
import java.util.*;
import model.TipoMovimiento;

public class TipoMovimientoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<TipoMovimiento> listar() {
        List<TipoMovimiento> lista = new ArrayList<>();
        String sql = "SELECT * FROM TipoMovimiento";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoMovimiento tm = new TipoMovimiento();
                tm.setIdTipoMovimiento(rs.getInt("idTipoMovimiento"));
                tm.setDetalle(rs.getString("detalle"));
                lista.add(tm);
            }
        } catch (Exception e) {
            System.out.println("Error en TipoMovimientoDAO.listar: " + e.getMessage());
        }
        return lista;
    }
    
    public String obtenerDetallePorId(int idTipoMovimiento) {
        String detalle = "";
        String sql = "SELECT detalle FROM TipoMovimiento WHERE idTipoMovimiento = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idTipoMovimiento);
            rs = ps.executeQuery();
            if (rs.next()) {
                detalle = rs.getString("detalle");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detalle;
    }

}
