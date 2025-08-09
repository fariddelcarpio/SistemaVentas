package controller;

import dao.MovimientosProductoDAO;
import dao.ProductoDAO;
import dao.TipoMovimientoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.MovimientosProducto;
import model.Producto;
import model.TipoMovimiento;

@WebServlet(name = "MovimientosProductoServlet", urlPatterns = {"/MovimientosProductoServlet"})
public class MovimientosProductoServlet extends HttpServlet {

    MovimientosProductoDAO movimientosDAO = new MovimientosProductoDAO();
    TipoMovimientoDAO tipoMovimientoDAO = new TipoMovimientoDAO();
    ProductoDAO productoDAO = new ProductoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "listar";

        switch (action) {
            case "listar":
                listar(request, response);
                break;
            case "registrar":
                mostrarFormularioRegistro(request, response);
                break;
            default:
                listar(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("guardar".equals(action)) {
            guardar(request, response);
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<MovimientosProducto> lista = movimientosDAO.listar();
        request.setAttribute("listaMovimientos", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("movimientos/listarMovimientoProducto.jsp");
        dispatcher.forward(request, response);
    }

    private void mostrarFormularioRegistro(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Producto> productos = productoDAO.listar();
        List<TipoMovimiento> tipos = tipoMovimientoDAO.listar();
        request.setAttribute("listaProductos", productos);
        request.setAttribute("listaTipoMovimientos", tipos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("movimientos/registrarMovimientoProducto.jsp");
        dispatcher.forward(request, response);
    }

    private void guardar(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        int idTipoMovimiento = Integer.parseInt(request.getParameter("idTipoMovimiento"));
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        // 1. Registrar movimiento
        MovimientosProducto mp = new MovimientosProducto();
        mp.setIdTipoMovimiento(idTipoMovimiento);
        mp.setIdProducto(idProducto);
        mp.setCantidad(cantidad);
        movimientosDAO.agregar(mp);

        // 2. Obtener tipo (Ingreso/Salida) y producto
        String tipo = tipoMovimientoDAO.obtenerDetallePorId(idTipoMovimiento);
        Producto producto = productoDAO.obtenerPorId(idProducto);
        int stockActual = producto.getStock();

        // 3. Calcular nuevo stock
        int nuevoStock = stockActual;
        if (tipo.equalsIgnoreCase("ENTRADA")) {
            nuevoStock += cantidad;
        } else if (tipo.equalsIgnoreCase("SALIDA")) {
            nuevoStock = Math.max(0, stockActual - cantidad);
        }

        // 4. Actualizar stock
        producto.setStock(nuevoStock);
        productoDAO.actualizarStock(idProducto, nuevoStock);

        // 5. Redirigir
        response.sendRedirect("MovimientosProductoServlet?action=listar");
    }
}
