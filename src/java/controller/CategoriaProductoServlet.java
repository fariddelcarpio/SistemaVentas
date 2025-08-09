package controller;

import dao.CategoriaProductoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import model.CategoriaProducto;

@WebServlet(name = "CategoriaProductoServlet", urlPatterns = {"/CategoriaProductoServlet"})
public class CategoriaProductoServlet extends HttpServlet {

    CategoriaProductoDAO dao = new CategoriaProductoDAO();

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
        List<CategoriaProducto> lista = dao.listar();
        request.setAttribute("listaCategorias", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("categorias/listarCategoria.jsp");
        dispatcher.forward(request, response);
    }

    private void agregar(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        CategoriaProducto c = new CategoriaProducto();
        c.setNombreCategoria(request.getParameter("nombreCategoria"));
        dao.agregar(c);
        response.sendRedirect("CategoriaProductoServlet?action=listar");
    }

    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CategoriaProducto categoria = dao.obtenerPorId(id);
        request.setAttribute("categoria", categoria);
        RequestDispatcher dispatcher = request.getRequestDispatcher("categorias/editarCategoria.jsp");
        dispatcher.forward(request, response);
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        CategoriaProducto c = new CategoriaProducto();
        c.setIdCategoriaProducto(Integer.parseInt(request.getParameter("idCategoriaProducto")));
        c.setNombreCategoria(request.getParameter("nombreCategoria"));
        dao.actualizar(c);
        response.sendRedirect("CategoriaProductoServlet?action=listar");
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        dao.eliminar(id);
        response.sendRedirect("CategoriaProductoServlet?action=listar");
    }
}

