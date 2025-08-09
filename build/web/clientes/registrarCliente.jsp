<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registrar Cliente</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"/>
</head>
<body>
<div class="container mt-4">
    <h2>Registrar Cliente</h2>
    <form action="ClienteServlet" method="post">
        <input type="hidden" name="action" value="agregar">
        <div class="form-group">
            <label>Nombres:</label>
            <input type="text" name="nombres" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Apellido Paterno:</label>
            <input type="text" name="apellidoPaterno" class="form-control" required>
        </div>
        <div class="form-group">
            <label>DNI:</label>
            <input type="text" name="dni" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Dirección:</label>
            <input type="text" name="direccion" class="form-control">
        </div>
        <div class="form-group">
            <label>Correo Electrónico:</label>
            <input type="email" name="correoElectronico" class="form-control">
        </div>
        <button type="submit" class="btn btn-success">Guardar</button>
        <a href="ClienteServlet?action=listar" class="btn btn-secondary">Cancelar</a>
    </form>
</div>
</body>
</html>
