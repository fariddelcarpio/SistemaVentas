package controller;

import dao.ClienteDAO;
import dao.FacturaDAO;
import dao.ProductoDAO;
import model.Cliente;
import model.DetalleFactura;
import model.Factura;
import model.Producto;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "FacturaServlet", urlPatterns = {"/FacturaServlet"})
public class FacturaServlet extends HttpServlet {

    FacturaDAO facturaDAO = new FacturaDAO();
    ClienteDAO clienteDAO = new ClienteDAO();
    ProductoDAO productoDAO = new ProductoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "listar";

        switch (action) {
            case "listar":
                listarFacturas(request, response);
                break;
            case "detalle":
                mostrarDetalleFactura(request, response);
                break;
            case "registrar":
                mostrarFormularioFactura(request, response);
                break;
            default:
                listarFacturas(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("guardar".equals(action)) {
            registrarFactura(request, response);
        }
    }

    private void listarFacturas(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Factura> lista = facturaDAO.listarFacturas();
        request.setAttribute("facturas", lista);
        request.getRequestDispatcher("facturas/listarFactura.jsp").forward(request, response);
    }

    private void mostrarFormularioFactura(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Cliente> clientes = clienteDAO.listar();
        List<Producto> productos = productoDAO.listar();
        request.setAttribute("listaClientes", clientes);
        request.setAttribute("listaProductos", productos);
        request.getRequestDispatcher("facturas/registrarFactura.jsp").forward(request, response);
    }

    private void registrarFactura(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {

    try {
        String[] idProductos = request.getParameterValues("idProducto[]");
        String[] cantidades = request.getParameterValues("cantidad[]");
        String[] precios = request.getParameterValues("precioUnitario[]");

        if (idProductos == null || cantidades == null || precios == null) {
            throw new IllegalArgumentException("Faltan datos del formulario.");
        }

        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        double montoTotal = Double.parseDouble(request.getParameter("montoTotal"));

        Factura f = new Factura();
        f.setIdCliente(idCliente);
        f.setMontoTotal(montoTotal);

        List<DetalleFactura> detalles = new ArrayList<>();
        for (int i = 0; i < idProductos.length; i++) {
            DetalleFactura d = new DetalleFactura();
            d.setIdProducto(Integer.parseInt(idProductos[i]));
            d.setCantidad(Integer.parseInt(cantidades[i]));
            d.setPrecioUnitario(Double.parseDouble(precios[i]));
            d.setSubtotal(d.getCantidad() * d.getPrecioUnitario());
            detalles.add(d);
        }

        facturaDAO.registrarFactura(f, detalles);
        response.sendRedirect("FacturaServlet?action=listar");

    } catch (Exception e) {
        // Si algo falla, vuelve a mostrar el formulario con los datos
        request.setAttribute("error", "Error al registrar la factura: " + e.getMessage());

        // Reenvía datos para que no falle el JSP
        List<Cliente> clientes = clienteDAO.listar();
        List<Producto> productos = productoDAO.listar();
        request.setAttribute("listaClientes", clientes);
        request.setAttribute("listaProductos", productos);

        request.getRequestDispatcher("facturas/registrarFactura.jsp").forward(request, response);
    }
}


    private void mostrarDetalleFactura(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int idVentaCabecera = Integer.parseInt(request.getParameter("id"));
        List<DetalleFactura> detalles = facturaDAO.listarDetalleFactura(idVentaCabecera);
        request.setAttribute("detalles", detalles);
        request.getRequestDispatcher("facturas/detalleFactura.jsp").forward(request, response);
    }
}
