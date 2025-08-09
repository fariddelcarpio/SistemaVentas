package controller;

import dao.EmpleadoDAO;
import model.Empleado;
import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "EmpleadoServlet", urlPatterns = {"/EmpleadoServlet"})
public class EmpleadoServlet extends HttpServlet {

    EmpleadoDAO dao = new EmpleadoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("listar".equals(action)) {
            List<Empleado> lista = dao.listar();
            request.setAttribute("empleados", lista);
            request.getRequestDispatcher("empleados/listarEmpleado.jsp").forward(request, response);
        } else if ("registrar".equals(action)) {
            request.getRequestDispatcher("empleados/registrarEmpleado.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String nombres = request.getParameter("nombres");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String correoelectronico = request.getParameter("correoelectronico");
        String direccion = request.getParameter("direccion");

        Empleado e = new Empleado();
        e.setNombres(nombres);
        e.setApellidoPaterno(apellidoPaterno);
        e.setFechaNacimiento(fechaNacimiento);
        e.setCorreoelectronico(correoelectronico);
        e.setDireccion(direccion);

        dao.registrar(e);
        response.sendRedirect("EmpleadoServlet?action=listar");
    }
}
