<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Cliente</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"/>
</head>
<body>
<div class="container mt-4">
    <h2>Editar Cliente</h2>
    <form action="ClienteServlet" method="post">
        <input type="hidden" name="action" value="actualizar">
        <input type="hidden" name="idCliente" value="${cliente.idCliente}">
        <div class="form-group">
            <label>Nombres:</label>
            <input type="text" name="nombres" value="${cliente.nombres}" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Apellido Paterno:</label>
            <input type="text" name="apellidoPaterno" value="${cliente.apellidoPaterno}" class="form-control" required>
        </div>
        <div class="form-group">
            <label>DNI:</label>
            <input type="text" name="dni" value="${cliente.dni}" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Dirección:</label>
            <input type="text" name="direccion" value="${cliente.direccion}" class="form-control">
        </div>
        <div class="form-group">
            <label>Correo Electrónico:</label>
            <input type="email" name="correoElectronico" value="${cliente.correoElectronico}" class="form-control">
        </div>
        <button type="submit" class="btn btn-success">Actualizar</button>
        <a href="ClienteServlet?action=listar" class="btn btn-secondary">Cancelar</a>
    </form>
</div>
</body>
</html>
