<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Usuarios del Sistema</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #aaa;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
    <h2>Usuarios del Sistema</h2>
    <p><a href="registrarEmpleadoSistema.jsp">Agregar Usuario</a></p>
    
    <table>
        <tr>
            <th>ID</th>
            <th>ID Empleado</th>
            <th>Usuario</th>
            <th>ID Perfil</th>
            <th>Acciones</th>
        </tr>

        <c:forEach var="e" items="${lista}">
            <tr>
                <td>${e.idEmpleadoSistema}</td>
                <td>${e.idEmpleado}</td>
                <td>${e.usuario}</td>
                <td>${e.idPerfilUsuario}</td>
                <td>
                    <a href="EmpleadoSistemaServlet?action=editar&id=${e.idEmpleadoSistema}">Editar</a> |
                    <a href="EmpleadoSistemaServlet?action=eliminar&id=${e.idEmpleadoSistema}" onclick="return confirm('¿Estás seguro de eliminar este usuario?')">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
