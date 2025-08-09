package controller;

import dao.EmpleadoSistemaDAO;
import model.EmpleadoSistema;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/EmpleadoSistemaServlet")
public class EmpleadoSistemaServlet extends HttpServlet {
    EmpleadoSistemaDAO dao = new EmpleadoSistemaDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");

        switch (action) {
            case "listar":
                List<EmpleadoSistema> lista = dao.listar();
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("empleadosSistemas/listarEmpleadoSistema.jsp").forward(request, response);
                break;
            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                EmpleadoSistema es = dao.buscar(idEditar);
                request.setAttribute("empleadoSistema", es);
                request.getRequestDispatcher("empleadosSistemas/editarEmpleadoSistema.jsp").forward(request, response);
                break;
            case "eliminar":
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(idEliminar);
                response.sendRedirect("EmpleadoSistemaServlet");
                break;
            default:
                response.sendRedirect("EmpleadoSistemaServlet");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        EmpleadoSistema e = new EmpleadoSistema();
        e.setIdEmpleado(Integer.parseInt(request.getParameter("idEmpleado")));
        e.setUsuario(request.getParameter("usuario"));
        e.setPassword(request.getParameter("password"));
        e.setIdPerfilUsuario(Integer.parseInt(request.getParameter("idPerfilUsuario")));

        if ("registrar".equals(action)) {
            dao.registrar(e);
        } else if ("actualizar".equals(action)) {
            e.setIdEmpleadoSistema(Integer.parseInt(request.getParameter("idEmpleadoSistema")));
            dao.actualizar(e);
        }

        response.sendRedirect("EmpleadoSistemaServlet");
    }
}
