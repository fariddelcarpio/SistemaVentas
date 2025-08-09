<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.PerfilUsuario" %>
<%
    List<PerfilUsuario> perfiles = (List<PerfilUsuario>) request.getAttribute("perfiles");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Perfiles</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="bg-light">

<div class="container mt-4">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/ProyectoFinal/index.jsp">Inicio</a></li>
            <li class="breadcrumb-item active" aria-current="page">Perfiles de Usuario</li>
        </ol>
    </nav>

    <div class="d-flex justify-content-between align-items-center mb-3">
        <h2 class="mb-0">Perfiles de Usuario</h2>
        <a href="PerfilUsuarioServlet?action=agregarForm" class="btn btn-primary">Agregar Nuevo Perfil</a>
    </div>

    <table class="table table-bordered table-striped table-hover">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Descripción</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
        <% for (PerfilUsuario p : perfiles) { %>
            <tr>
                <td><%= p.getIdPerfilUsuario() %></td>
                <td><%= p.getDescripcion() %></td>
                <td>
                    <form action="PerfilUsuarioServlet" method="post" onsubmit="return confirm('¿Seguro que deseas eliminar este perfil?');">
                        <input type="hidden" name="action" value="eliminar" />
                        <input type="hidden" name="id" value="<%= p.getIdPerfilUsuario() %>" />
                        <button type="submit" class="btn btn-danger btn-sm">Eliminar</button>
                    </form>
                </td>
            </tr>
        <% } %>
        </tbody>
    </table>
</div>

</body>
</html>
