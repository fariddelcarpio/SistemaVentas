package dao;

import config.Conexion;
import model.Factura;
import model.DetalleFactura;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public int registrarFactura(Factura factura, List<DetalleFactura> detalles) {
        int idGenerado = 0;
        try {
            con = cn.getConexion();
            con.setAutoCommit(false); // Inicia transacción

            // 1. Insertar en VentasCabecera
            String sqlCab = "INSERT INTO VentasCabecera (fecha, idCliente, MontoTotal) VALUES (NOW(), ?, ?)";
            ps = con.prepareStatement(sqlCab, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, factura.getIdCliente());
            ps.setDouble(2, factura.getMontoTotal());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }

            // 2. Insertar detalles
            String sqlDet = "INSERT INTO VentasDetalle (idVentaCabecera, idProducto, cantidad, precioUnitario, subtotal) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sqlDet);

            for (DetalleFactura df : detalles) {
                ps.setInt(1, idGenerado);
                ps.setInt(2, df.getIdProducto());
                ps.setInt(3, df.getCantidad());
                ps.setDouble(4, df.getPrecioUnitario());
                ps.setDouble(5, df.getSubtotal());
                ps.addBatch();
            }

            ps.executeBatch();
            con.commit();
        } catch (SQLException e) {
            try {
                if (con != null) con.rollback();
            } catch (SQLException ex) {}
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.setAutoCommit(true);
                if (ps != null) ps.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {}
        }
        return idGenerado;
    }

    public List<Factura> listarFacturas() {
        List<Factura> lista = new ArrayList<>();
        String sql = "SELECT vc.idVentaCabecera, vc.fecha, vc.idCliente, vc.MontoTotal, c.nombres " +
                     "FROM VentasCabecera vc " +
                     "JOIN Cliente c ON vc.idCliente = c.idCliente " +
                     "ORDER BY vc.fecha DESC";

        try {
            con = cn.getConexion()  ;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Factura f = new Factura();
                f.setIdVentaCabecera(rs.getInt("idVentaCabecera"));
                f.setFecha(rs.getTimestamp("fecha"));
                f.setIdCliente(rs.getInt("idCliente"));
                f.setMontoTotal(rs.getDouble("MontoTotal"));
                f.setClienteNombre(rs.getString("nombres"));
                lista.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<DetalleFactura> listarDetalleFactura(int idVentaCabecera) {
        List<DetalleFactura> lista = new ArrayList<>();
        String sql = "SELECT vd.*, p.nombre FROM VentasDetalle vd " +
                     "JOIN Producto p ON vd.idProducto = p.idProducto " +
                     "WHERE vd.idVentaCabecera = ?";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idVentaCabecera);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetalleFactura df = new DetalleFactura();
                df.setIdVentasDetalle(rs.getInt("idVentasDetalle"));
                df.setIdVentaCabecera(rs.getInt("idVentaCabecera"));
                df.setIdProducto(rs.getInt("idProducto"));
                df.setCantidad(rs.getInt("cantidad"));
                df.setPrecioUnitario(rs.getDouble("precioUnitario"));
                df.setSubtotal(rs.getDouble("subtotal"));
                df.setNombreProducto(rs.getString("nombre"));
                lista.add(df);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
