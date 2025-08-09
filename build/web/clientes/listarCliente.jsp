<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Clientes</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"/>
</head>
<body>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="/ProyectoFinal/index.jsp">Inicio</a></li>
          <li class="breadcrumb-item active" aria-current="page">Clientes</li>
        </ol>
    </nav>
<div class="container mt-4">
    <h2>Clientes</h2>
    <a href="ClienteServlet?action=nuevo" class="btn btn-primary mb-3">Registrar Cliente</a>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombres</th>
                <th>Apellido</th>
                <th>DNI</th>
                <th>Dirección</th>
                <th>Correo</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="c" items="${listaClientes}">
                <tr>
                    <td>${c.idCliente}</td>
                    <td>${c.nombres}</td>
                    <td>${c.apellidoPaterno}</td>
                    <td>${c.dni}</td>
                    <td>${c.direccion}</td>
                    <td>${c.correoElectronico}</td>
                    <td>
                        <a href="ClienteServlet?action=editar&id=${c.idCliente}" class="btn btn-warning btn-sm">Editar</a>
                        <a href="ClienteServlet?action=eliminar&id=${c.idCliente}" 
                            class="btn btn-danger btn-sm"
                            onclick="return confirm('¿Está seguro que desea eliminar este cliente?');">
                            Eliminar
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
