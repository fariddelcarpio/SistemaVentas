package controller;

import dao.ClienteDAO;
import model.Cliente;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    ClienteDAO clienteDAO = new ClienteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "listar";

        switch (action) {
            case "listar":
                listar(request, response);
                break;
            case "editar":
                mostrarFormularioEditar(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;
            case "nuevo":
                mostrarFormularioAgregar(request, response);
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
        List<Cliente> clientes = clienteDAO.listar();
        request.setAttribute("listaClientes", clientes);
        request.getRequestDispatcher("clientes/listarCliente.jsp").forward(request, response);
    }

    private void mostrarFormularioAgregar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.getRequestDispatcher("clientes/registrarCliente.jsp").forward(request, response);
    }

    private void agregar(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        Cliente c = new Cliente();
        c.setNombres(request.getParameter("nombres"));
        c.setApellidoPaterno(request.getParameter("apellidoPaterno"));
        c.setDni(request.getParameter("dni"));
        c.setDireccion(request.getParameter("direccion"));
        c.setCorreoElectronico(request.getParameter("correoElectronico"));

        clienteDAO.agregar(c);
        response.sendRedirect("ClienteServlet?action=listar");
    }

    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = clienteDAO.obtenerPorId(id);
        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher("clientes/editarCliente.jsp").forward(request, response);
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        Cliente c = new Cliente();
        c.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));
        c.setNombres(request.getParameter("nombres"));
        c.setApellidoPaterno(request.getParameter("apellidoPaterno"));
        c.setDni(request.getParameter("dni"));
        c.setDireccion(request.getParameter("direccion"));
        c.setCorreoElectronico(request.getParameter("correoElectronico"));

        clienteDAO.actualizar(c);
        response.sendRedirect("ClienteServlet?action=listar");
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        clienteDAO.eliminar(id);
        response.sendRedirect("ClienteServlet?action=listar");
    }
}