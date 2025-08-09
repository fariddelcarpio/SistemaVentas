<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Empleado" %>
<%
    List<Empleado> empleados = (List<Empleado>) request.getAttribute("empleados");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Empleados</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="/ProyectoFinal/index.jsp">Inicio</a></li>
          <li class="breadcrumb-item active" aria-current="page">Empleados</li>
        </ol>
    </nav>
    <div class="container mt-5">
        <h2 class="text-center mb-4">Lista de Empleados</h2>
        <div class="mb-3 text-end">
            <a href="EmpleadoServlet?action=registrar" class="btn btn-success">Registrar Nuevo</a>
        </div>
        <div class="table-responsive">
            <table class="table table-bordered table-hover bg-white">
                <thead class="table-primary">
                    <tr>
                        <th>ID</th>
                        <th>Nombres</th>
                        <th>Apellido</th>
                        <th>Nacimiento</th>
                        <th>Email</th>
                        <th>Dirección</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Empleado e : empleados) { %>
                        <tr>
                            <td><%= e.getIdEmpleado() %></td>
                            <td><%= e.getNombres() %></td>
                            <td><%= e.getApellidoPaterno() %></td>
                            <td><%= e.getFechaNacimiento() %></td>
                            <td><%= e.getCorreoelectronico() %></td>
                            <td><%= e.getDireccion() %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
