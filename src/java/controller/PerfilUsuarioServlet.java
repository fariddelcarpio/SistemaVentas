package controller;

import dao.PerfilUsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.PerfilUsuario;

@WebServlet("/PerfilUsuarioServlet")
public class PerfilUsuarioServlet extends HttpServlet {
    PerfilUsuarioDAO dao = new PerfilUsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String action = request.getParameter("action") != null ? request.getParameter("action") : "listar";

        switch (action) {
            case "listar":
                List<PerfilUsuario> lista = dao.listar();
                request.setAttribute("perfiles", lista);
                request.getRequestDispatcher("perfiles/listarPerfil.jsp").forward(request, response);
                break;
            case "eliminar":
                int id = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(id);
                response.sendRedirect("PerfilUsuarioServlet?action=listar");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String descripcion = request.getParameter("descripcion");
        PerfilUsuario perfil = new PerfilUsuario();
        perfil.setDescripcion(descripcion);
        dao.agregar(perfil);
        response.sendRedirect("PerfilUsuarioServlet?action=listar");
    }
}
