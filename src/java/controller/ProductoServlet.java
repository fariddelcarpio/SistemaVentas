package controller;

import dao.CategoriaProductoDAO;
import dao.ProductoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.CategoriaProducto;
import model.Producto;

@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {

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
            case "eliminar":
                eliminar(request, response);
                break;
            case "editar":
                mostrarFormularioEditar(request, response);
                break;
            case "registrar":
                mostrarFormularioRegistro(request, response);
                break;
            default:
                listar(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "agregar":
                agregar(request, response);
                break;
            case "actualizar":
                actualizar(request, response);
                break;
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Producto> productos = productoDAO.listar();
        request.setAttribute("listaProductos", productos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("productos/listarProducto.jsp");
        dispatcher.forward(request, response);
    }

    private void agregar(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        Producto p = new Producto();
        p.setIdCategoriaProducto(Integer.parseInt(request.getParameter("idCategoriaProducto")));
        p.setCodigoBarras(request.getParameter("codigoBarras"));
        p.setNombre(request.getParameter("nombre"));
        p.setPrecioUnitario(Double.parseDouble(request.getParameter("precioUnitario")));
        p.setUnidadMedida(request.getParameter("unidadMedida"));
        p.setStock(Integer.parseInt(request.getParameter("stock")));

        productoDAO.agregar(p);
        response.sendRedirect("ProductoServlet?action=listar");
    }

    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Producto producto = productoDAO.obtenerPorId(id);

        CategoriaProductoDAO categoriaDAO = new CategoriaProductoDAO();
        List<CategoriaProducto> categorias = categoriaDAO.listar();

        request.setAttribute("producto", producto);
        request.setAttribute("listaCategorias", categorias);
        RequestDispatcher dispatcher = request.getRequestDispatcher("productos/editarProducto.jsp");
        dispatcher.forward(request, response);
    }

    private void mostrarFormularioRegistro(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        CategoriaProductoDAO categoriaDAO = new CategoriaProductoDAO();
        List<CategoriaProducto> categorias = categoriaDAO.listar();

        request.setAttribute("listaCategorias", categorias);
        RequestDispatcher dispatcher = request.getRequestDispatcher("productos/registrarProducto.jsp");
        dispatcher.forward(request, response);
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        Producto p = new Producto();
        p.setIdProducto(Integer.parseInt(request.getParameter("idProducto")));
        p.setIdCategoriaProducto(Integer.parseInt(request.getParameter("idCategoriaProducto")));
        p.setCodigoBarras(request.getParameter("codigoBarras"));
        p.setNombre(request.getParameter("nombre"));
        p.setPrecioUnitario(Double.parseDouble(request.getParameter("precioUnitario")));
        p.setUnidadMedida(request.getParameter("unidadMedida"));
        p.setStock(Integer.parseInt(request.getParameter("stock")));

        productoDAO.actualizar(p);
        response.sendRedirect("ProductoServlet?action=listar");
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productoDAO.eliminar(id);
        response.sendRedirect("ProductoServlet?action=listar");
    }
}
